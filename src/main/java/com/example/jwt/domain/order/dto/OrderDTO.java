package com.example.jwt.domain.order.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.placeorder.dto.PlaceOrderDTO;
import com.example.jwt.domain.user.dto.UserDTO;

import java.util.Set;


public class OrderDTO extends ExtendedDTO {

    private Boolean status;

    private Long discount;

    private UserDTO appuser;

    private double totalPrice;

    private Set<PlaceOrderDTO> placeOrders;


    public OrderDTO(Boolean status, Long discount, UserDTO appuser, double totalPrice, Set<PlaceOrderDTO> placeOrders) {
        this.status = status;
        this.discount = discount;
        this.appuser = appuser;
        this.totalPrice = totalPrice;
        this.placeOrders = placeOrders;
    }

    public OrderDTO() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public UserDTO getAppuser() {
        return appuser;
    }

    public void setAppuser(UserDTO appuser) {
        this.appuser = appuser;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<PlaceOrderDTO> getPlaceOrders() {
        return placeOrders;
    }

    public void setPlaceOrders(Set<PlaceOrderDTO> placeOrders) {
        this.placeOrders = placeOrders;
    }
}
