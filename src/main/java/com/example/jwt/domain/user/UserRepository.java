package com.example.jwt.domain.user;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.domain.rank.Rank;
import com.example.jwt.domain.user.dto.NameSumDisxountDTO;
import com.example.jwt.domain.user.dto.UserIdNameAndPriceSpendDTO;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface UserRepository extends ExtendedRepository<User> {
    Optional<User> findByEmail(String email);

    @Query(value = "select users.first_name as firstname, users.last_name as lastname, sum(o.total_price) as sum from users\n" +
            "left join orders o on users.id = o.user_id\n" +
            "left join place_order po on o.id = po.order_id\n" +
            "where po.ordertime > CURRENT_DATE - INTERVAL '1 months'\n" +
            "group by users.id, users.first_name, users.last_name\n" +
            "order by sum desc limit 1;", nativeQuery = true)
    UserIdNameAndPriceSpendDTO getUserSpendMost();


    @Query(value = "select users.first_name as firstname ,users.last_name as lastname, sum(o.discount) as sumdiscount from users\n" +
            "            left join orders o on users.id = o.user_id\n" +
            "            left join place_order po on o.id = po.order_id\n" +
            "            where po.ordertime between :date1 and :date2\n" +
            "            group by users.first_name, users.last_name;", nativeQuery = true)
    List<NameSumDisxountDTO> getUsersSumDiscount(@Param("date1") Timestamp date1, @Param("date2") Timestamp date2);

    //between to dates ergänzen

}
