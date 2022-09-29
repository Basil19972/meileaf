package com.example.jwt.domain.order;

import com.example.jwt.domain.order.dto.OrderDTO;
import com.example.jwt.domain.order.dto.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Validated
@RestController
@RequestMapping("/order")
public class OrderController {


    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService placeOrderService, OrderMapper orderMapper) {
        this.orderService = placeOrderService;

        this.orderMapper = orderMapper;
    }


    @PostMapping()
    @PreAuthorize("hasAuthority('ORDER_WRITE')")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(orderMapper.toDTO(orderService.placeOrder(orderMapper.fromDTO(orderDTO))), HttpStatus.CREATED);
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('ORDER_READ')")
    public ResponseEntity<Set<OrderDTO>> findAll() {

        Set<OrderDTO> orderDTOS = orderMapper.toDTOs(orderService.findallOrdersbyUser());
        return new ResponseEntity<>(orderDTOS, HttpStatus.OK);

    }


}
