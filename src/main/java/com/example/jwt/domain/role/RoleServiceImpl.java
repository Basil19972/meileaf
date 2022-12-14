package com.example.jwt.domain.role;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.core.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService {

    @Autowired
    protected RoleServiceImpl(ExtendedRepository<Role> repository) {
        super(repository);
    }

    public Role GetDefaultRole() {

        return ((RoleRepository) super.getRepository()).findByName("USER");
    }


}
