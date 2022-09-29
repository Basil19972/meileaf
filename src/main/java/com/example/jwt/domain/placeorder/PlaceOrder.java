package com.example.jwt.domain.placeorder;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.order.Order;
import com.example.jwt.domain.product.Product;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "place_order")
public class PlaceOrder extends ExtendedEntity {


    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "ordertime")
    private Timestamp orderTime;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    public PlaceOrder(Long quantity, Timestamp orderTime, Product product, Order order) {
        this.quantity = quantity;
        this.orderTime = orderTime;
        this.product = product;
        this.order = order;
    }

    public PlaceOrder(UUID uuid,Long quantity, Timestamp orderTime, Product product, Order order) {
        this.quantity = quantity;
        this.orderTime = orderTime;
        this.product = product;
        this.order = order;
        super.setId(uuid);
    }

    public PlaceOrder() {
    }


    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
