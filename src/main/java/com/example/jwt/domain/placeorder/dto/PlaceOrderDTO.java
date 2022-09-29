package com.example.jwt.domain.placeorder.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.product.dto.ProductDTO;


public class PlaceOrderDTO extends ExtendedDTO {

    private Long quantity;
    private ProductDTO product;


    public PlaceOrderDTO(Long quantity, ProductDTO product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
