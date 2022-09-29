package com.example.jwt.domain.order;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.placeorder.PlaceOrder;
import com.example.jwt.domain.user.User;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order extends ExtendedEntity {

    @Column(name = "status", nullable = true)
    private Boolean status;

    @Column(name = "discount", nullable = true)
    private int discount;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User appuser;

    @Column(name = "totalPrice", nullable = true)
    private double totalPrice;

    @Column(name = "totalPriceWithDiscount", nullable = true)
    private double totalPriceWithDiscount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST )
    private Set<PlaceOrder> placeOrders;

    public Order(UUID uuid,Boolean status, int discount, User appuser, double totalPriceWithDiscount) {
        this.status = status;
        this.discount = discount;
        this.appuser = appuser;
        this.totalPriceWithDiscount = totalPriceWithDiscount;
        super.setId(uuid);
    }

    public Order(UUID uuid,Boolean status, int discount, User appuser, double totalPriceWithDiscount, Set<PlaceOrder> placeOrders) {
        this.status = status;
        this.discount = discount;
        this.appuser = appuser;
        this.totalPriceWithDiscount = totalPriceWithDiscount;
        this.placeOrders = placeOrders;
        super.setId(uuid);
    }

    public Order(Boolean status, int discount, User appuser, double totalPriceWithDiscount, Set<PlaceOrder> placeOrders) {
        this.status = status;
        this.discount = discount;
        this.appuser = appuser;
        this.totalPriceWithDiscount = totalPriceWithDiscount;
        this.placeOrders = placeOrders;
    }

    public Order() {
    }

    public Order(Set<PlaceOrder> placeOrders) {
        this.placeOrders = placeOrders;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public User getAppuser() {
        return appuser;
    }

    public void setAppuser(User appuser) {
        this.appuser = appuser;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<PlaceOrder> getPlaceOrders() {
        return placeOrders;
    }

    public void setPlaceOrders(Set<PlaceOrder> placeOrders) {
        this.placeOrders = placeOrders;
    }

    public double getTotalPriceWithDiscount() {
        return totalPriceWithDiscount;
    }

    public void setTotalPriceWithDiscount(double totalPriceWithDiscount) {
        this.totalPriceWithDiscount = totalPriceWithDiscount;
    }
}
