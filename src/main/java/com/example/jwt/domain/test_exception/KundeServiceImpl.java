package com.example.jwt.domain.test_exception;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.core.generic.ExtendedServiceImpl;
import com.example.jwt.domain.order.Order;
import com.example.jwt.domain.order.OrderRepository;
import com.example.jwt.domain.order.OrderService;
import com.example.jwt.domain.placeorder.PlaceOrder;
import com.example.jwt.domain.product.ProduktService;
import com.example.jwt.domain.rank.Rank;
import com.example.jwt.domain.rank.RankService;
import com.example.jwt.domain.user.User;
import com.example.jwt.domain.user.UserDetailsImpl;
import com.example.jwt.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class KundeServiceImpl extends ExtendedServiceImpl<Kunde> implements KundeService {

    protected KundeServiceImpl(ExtendedRepository<Kunde> repository) {
        super(repository);
    }




}
