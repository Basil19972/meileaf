package com.example.jwt.domain.category;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.domain.category.dto.CategoryNameWhitCountDTO;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends ExtendedRepository<Category> {

    @Modifying
    @Type(type = "pg-uuid")
    @Query(value = "select c.name as name, count(p.category_id) as count from orders\n" +
            "left join place_order po on orders.id = po.order_id\n" +
            "left join products p on p.id = po.product_id\n" +
            "left join categories c on c.id = p.category_id\n" +
            "left join users u on u.id = orders.user_id\n" +
            "where user_id = :userid\n" +
            "group by p.category_id, c.name", nativeQuery = true)
    List<CategoryNameWhitCountDTO[]> getCategoryWhitCountFromUser(@Param("userid") UUID userid);





}