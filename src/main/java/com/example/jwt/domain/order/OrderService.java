package com.example.jwt.domain.order;

import com.example.jwt.core.generic.ExtendedService;

import java.util.Set;

public interface OrderService extends ExtendedService<Order> {
    Order placeOrder(Order order);

    Set<Order> findallOrdersbyUser();
}
