package com.example.jwt.domain.order;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderRepository extends ExtendedRepository<Order> {

    //FindBYName

    Set<Order> findAllByAppuser(User user);


    //  @Query(value = "select * from product where name = :name ", nativeQuery = true)
    //  public List<Product> getByNameQuery(@Param("name") String name);

}