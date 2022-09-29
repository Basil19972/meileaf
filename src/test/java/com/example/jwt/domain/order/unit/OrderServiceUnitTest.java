package com.example.jwt.domain.order.unit;

import com.example.jwt.domain.authority.Authority;
import com.example.jwt.domain.category.Category;
import com.example.jwt.domain.category.CategoryRepository;
import com.example.jwt.domain.category.CategoryService;
import com.example.jwt.domain.order.Order;
import com.example.jwt.domain.order.OrderRepository;
import com.example.jwt.domain.order.OrderServiceImpl;
import com.example.jwt.domain.product.Product;
import com.example.jwt.domain.product.ProductRepository;
import com.example.jwt.domain.rank.Rank;
import com.example.jwt.domain.role.Role;
import com.example.jwt.domain.user.User;
import com.example.jwt.domain.user.UserRepository;
import com.example.jwt.domain.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class OrderServiceUnitTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private UserService userService;

    @Mock
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private UserRepository userRepository;




    private Rank dummyRank;
    private Authority dummyAuthority;
    private Role dummyRole;
    private User dummyUser;
    private User dummyUserUnderage;


    private Category dummyCategory;
    private Category dummyCategory2;

    private Product dummyProduct1;
    private Product dummyProduct2;


    private Set<Product> dummyProducts = new HashSet<>();

    @BeforeEach
    public void setUp() {
        dummyRank = new Rank(UUID.randomUUID(), "TestRank", 0, 0, true);

        dummyAuthority = new Authority(UUID.randomUUID(), "ORDER_READ");

        dummyRole = new Role(UUID.randomUUID(),"USER",Set.of(dummyAuthority));

        dummyUser = new User(UUID.randomUUID(), "Test", "Test", 25, "test.test@test.ch", "pw", true, dummyRank, 0,Set.of(dummyRole));
        userRepository.saveAndFlush(dummyUser);

        dummyUserUnderage = new User(UUID.randomUUID(), "Test", "Test", 17, "test.test@test.ch", "pw", true, dummyRank, 0,Set.of(dummyRole));
        userRepository.saveAndFlush(dummyUserUnderage);


        dummyCategory = new Category(UUID.randomUUID(),"TestCat",null,18);
        dummyCategory2 = new Category(UUID.randomUUID(),"TestCat",null,17);


        dummyProduct1 = new Product(UUID.randomUUID(),10,"TestProduct",null,20.0,10.0,null,dummyCategory);
        dummyProduct2 = new Product(UUID.randomUUID(),20,"TestProduct2",null,30.0,20.0,null,dummyCategory);

        dummyProducts.add(dummyProduct1);
        dummyProducts.add(dummyProduct2);

    }

    @DisplayName("Test1 true")
    @Test
    public void Case1doesUserComplyWithAgeRestrictions_provideOldEnoughUser_expectGrantToOrder() throws Exception {

        given(userService.getCurrentUser()).willReturn(dummyUser);
        given(categoryService.findById(any(UUID.class))).willReturn(dummyCategory);

        assertThat(orderService.isProductOver18(dummyProducts)).isEqualTo(true);

    }

    @DisplayName("Test1 false")
    @Test
    public void Case2doesUserComplyWithAgeRestrictions_provideOldEnoughUser_expectGrantToOrder() throws Exception {

        given(userService.getCurrentUser()).willReturn(dummyUserUnderage);
        given(categoryService.findById(any(UUID.class))).willReturn(dummyCategory);

        assertThat(orderService.isProductOver18(dummyProducts)).isEqualTo(false);

    }
}
