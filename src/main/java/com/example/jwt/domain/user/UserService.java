package com.example.jwt.domain.user;

import com.example.jwt.core.generic.ExtendedService;
import com.example.jwt.domain.user.dto.NameSumDisxountDTO;
import com.example.jwt.domain.user.dto.UserIdNameAndPriceSpendDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService extends UserDetailsService, ExtendedService<User> {

    User getCurrentUser();
    User register(User user);

    User lockUser(UUID id);

    UserIdNameAndPriceSpendDTO getUserSpendTheMost();
    List<NameSumDisxountDTO> getUsersSumDiscount(String date1, String date2);


}



