package com.example.jwt.domain.product;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends ExtendedRepository<Product> {

    Set<Product> findProductsByCategory(User user);


}