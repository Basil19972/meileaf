package com.example.jwt.domain.role.dto;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.core.generic.ExtendedService;
import com.example.jwt.domain.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService implements ExtendedService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    // public void setDefaultRole(UUID userID){

    //   Role casualUser = roleRepository.findAllByNameContains("CasualUser");
    //    UUID uuidCasualUser = casualUser.getId();

    //    System.out.println("----------->"+ uuidCasualUser);
    //    System.out.println("---------->" + userID);

    //  }

    @Override
    public ExtendedEntity save(ExtendedEntity entity) {
        return null;
    }

    @Override
    public Void deleteById(UUID id) throws NoSuchElementException {
        return null;
    }

    @Override
    public ExtendedEntity updateById(UUID id, ExtendedEntity entity) throws NoSuchElementException {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ExtendedEntity findById(UUID id) {
        return null;
    }

    @Override
    public boolean existsById(UUID id) {
        return false;
    }

    @Override
    public ExtendedEntity findOrThrow(Optional optional) throws NoSuchElementException {
        return null;
    }
}
