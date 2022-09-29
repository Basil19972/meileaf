package com.example.jwt.domain.user;

import com.example.jwt.core.exception.CantDeleteAdminException;
import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.core.generic.ExtendedServiceImpl;
import com.example.jwt.core.security.config.Roles;
import com.example.jwt.domain.rank.RankService;
import com.example.jwt.domain.rank.RankServiceImpl;
import com.example.jwt.domain.role.Role;
import com.example.jwt.domain.role.RoleService;
import com.example.jwt.domain.user.dto.NameSumDisxountDTO;
import com.example.jwt.domain.user.dto.UserIdNameAndPriceSpendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;
    private final RankService rankService;


    @Autowired
    public UserServiceImpl(ExtendedRepository<User> repository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService, RankServiceImpl rankService) {
        super(repository);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
        this.rankService = rankService;
    }


    public UserIdNameAndPriceSpendDTO getUserSpendTheMost() {
        return ((UserRepository) super.getRepository()).getUserSpendMost();
    }

    @Override
    public List<NameSumDisxountDTO> getUsersSumDiscount(String date1, String date2){

        Timestamp timestamp10 = null;
        Timestamp timestamp20 = null;
        try {
            Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
            java.sql.Timestamp timestamp1 = new java.sql.Timestamp(date3.getTime());

            Date date4 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
            java.sql.Timestamp timestamp2 = new java.sql.Timestamp(date4.getTime());

            timestamp10 = timestamp1;
            timestamp20 = timestamp2;

        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        return ((UserRepository) super.getRepository()).getUsersSumDiscount(timestamp10,timestamp20);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return ((UserRepository) super.getRepository()).findByEmail(email).map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException(email));
    }


    @Override
    public User register(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setNotLocked(true);
        user.setRoles(new HashSet<Role>(Arrays.asList(roleService.GetDefaultRole())));
        user.setRank(rankService.findRankByDefaultRankIsTrue()); // mit enum erweitern
        user.setSeeds(0);

        return super.getRepository().save(user);


    }

    @Override
    public User lockUser(UUID id) {

        User user = ((UserRepository) super.getRepository()).findById(id).orElseThrow();

        for (Role role : user.getRoles()) {

            if (role.equals(roleService.findById(UUID.fromString(Roles.ADMIN.getUuid())))) {
                throw new CantDeleteAdminException("You cant delete an other Admin");
            }


        }
        findById(user.getId());
        user.setNotLocked(false);
        return updateById(user.getId(), user);
    }

    public User getCurrentUser(){
        //Get User UUID
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = ((UserDetailsImpl) principal).user();
        return user;
    }
}
