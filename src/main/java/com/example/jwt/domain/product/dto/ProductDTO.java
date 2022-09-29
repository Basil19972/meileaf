package com.example.jwt.domain.product.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.category.dto.CategoryDTO;
import com.example.jwt.domain.country.dto.CountryDTO;

import java.sql.Date;


public class ProductDTO extends ExtendedDTO {


    private String describtion;

    private CountryDTO country;

    private Double sellingprice100g;

    private Double buyingprice100g;

    private Date harvestdate;

    private CategoryDTO category;

    public ProductDTO(String describtion, CountryDTO country, Double sellingprice100g, Double buyingprice100g, Date harvestdate, CategoryDTO category) {
        this.describtion = describtion;
        this.country = country;
        this.sellingprice100g = sellingprice100g;
        this.buyingprice100g = buyingprice100g;
        this.harvestdate = harvestdate;
        this.category = category;
    }

    public ProductDTO() {
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public Double getSellingprice100g() {
        return sellingprice100g;
    }

    public void setSellingprice100g(Double sellingprice100g) {
        this.sellingprice100g = sellingprice100g;
    }

    public Double getBuyingprice100g() {
        return buyingprice100g;
    }

    public void setBuyingprice100g(Double buyingprice100g) {
        this.buyingprice100g = buyingprice100g;
    }

    public Date getHarvestdate() {
        return harvestdate;
    }

    public void setHarvestdate(Date harvestdate) {
        this.harvestdate = harvestdate;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
