package com.example.jwt.domain.order.integration;

import com.example.jwt.core.security.config.AuthorizationSchemas;
import com.example.jwt.core.security.config.JwtProperties;
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
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private OrderRepository orderRepository;


    private String generateToken(UUID subject) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());

        return Jwts.builder()
                .setClaims(Map.of("sub", subject))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMillis()))
                .setIssuer(jwtProperties.getIssuer())
                .signWith(Keys.hmacShaKeyFor(keyBytes))
                .compact();
    }


    @BeforeEach
    public void setUp() {}

    @Test
    public void findAll_requestAllOrdersByUser_expectNone() throws Exception {
        Rank dummyRank = new Rank(UUID.randomUUID(), "TestRank", 0, 0, true);
        rankRepository.saveAndFlush(dummyRank);

        Authority dummyAuthority = new Authority(UUID.randomUUID(), "ORDER_READ");
        authorityRepository.saveAndFlush(dummyAuthority);

        Role dummyRole = new Role(UUID.randomUUID(),"USER",Set.of(dummyAuthority));
        roleRepository.saveAndFlush(dummyRole);

        User dummyUser = new User(UUID.randomUUID(), "Test", "Test", 25, "test.test@test.ch", "pw", true, dummyRank, 0,Set.of(dummyRole));
        userRepository.saveAndFlush(dummyUser);

        Order dummyOrder1 = new Order(UUID.randomUUID(),true, 20,dummyUser,20.0);
          orderRepository.saveAndFlush(dummyOrder1);

        Order dummyOrder2 = new Order(UUID.randomUUID(),true, 40,dummyUser,10.0);
        orderRepository.saveAndFlush(dummyOrder2);

        List<Order> dummyOrders = new ArrayList<>();
        dummyOrders.add(dummyOrder1);
        dummyOrders.add(dummyOrder2);

        mvc.perform(MockMvcRequestBuilders
                        .get("/order")
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + generateToken(dummyUser.getId()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(Matchers.containsInAnyOrder(dummyOrders.get(0).getId().toString(), dummyOrders.get(1).getId().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].status").value(Matchers.containsInAnyOrder(dummyOrders.get(0).getStatus(), dummyOrders.get(1).getStatus())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].discount").value(Matchers.containsInAnyOrder(dummyOrders.get(0).getDiscount(), dummyOrders.get(1).getDiscount())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].totalPrice").exists());
    }

    // Post test got lost?
}
