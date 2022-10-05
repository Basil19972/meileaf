package com.example.jwt.domain.order.unit;

import com.example.jwt.domain.authority.Authority;
import com.example.jwt.domain.authority.AuthorityRepository;
import com.example.jwt.domain.order.Order;
import com.example.jwt.domain.order.OrderRepository;
import com.example.jwt.domain.rank.Rank;
import com.example.jwt.domain.rank.RankRepository;
import com.example.jwt.domain.role.Role;
import com.example.jwt.domain.role.RoleRepository;
import com.example.jwt.domain.user.User;
import com.example.jwt.domain.user.UserRepository;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderRepositoryUnitTests {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RankRepository rankRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;


    private Role dummyRole;
    private Set<Role> dummyRoles;

    private Rank dummyRank;
    private Authority dummyAuthority;
    private Set<Authority> dummyAuthoritys;

    private User dummyUser;
    private Set<User> dummyUsers;

    private Order dummyOrder;

    private Set<Order> dummyOrders;

    @BeforeEach
    public void setUp() {
        dummyRank = new Rank(UUID.randomUUID(), "TestRank", 0, 0, true);
        rankRepository.saveAndFlush(dummyRank);

        dummyAuthority = new Authority(UUID.randomUUID(), "PRODUCT_READ");
        authorityRepository.saveAndFlush(dummyAuthority);

        dummyRole = new Role(UUID.randomUUID(),"USER",Set.of(dummyAuthority));
        roleRepository.saveAndFlush(dummyRole);

        dummyUser = new User(UUID.randomUUID(), "Test", "Test", 25, "test.test@test.ch", "pw", true, dummyRank, 0,Set.of(dummyRole));
        userRepository.saveAndFlush(dummyUser);

        dummyOrder = new Order(UUID.randomUUID(),true,20,dummyUser,20.0);
        dummyOrder = orderRepository.saveAndFlush(dummyOrder);

    }


    @Test
    public void findAllByAppuser_requestAllOrdersByAppuser_expectOrders() {
        assertThat(orderRepository.findAllByAppuser(dummyUser)).isEqualTo(Set.of(dummyOrder));
    }

}
