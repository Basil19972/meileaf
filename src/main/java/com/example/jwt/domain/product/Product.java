package com.example.jwt.domain.product;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.category.Category;
import com.example.jwt.domain.country.Country;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;


@Entity
@Table(name = "products")
public class Product extends ExtendedEntity {

    @Column(name = "nummber", nullable = false)
    private long nummber;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(name = "sellingprice100g", nullable = false)
    private Double sellingprice100g;

    @Column(name = "buyingprice100g", nullable = false)
    private Double buyingprice100g;

    @Column(name = "harvestdate", nullable = false)
    private Date harvestdate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


//changes to trigger pipeline




    public Product(UUID uuid,long nummber, String description, Country country, Double sellingprice100g, Double buyingprice100g, Date harvestdate, Category category) {
        this.nummber = nummber;
        this.description = description;
        this.country = country;
        this.sellingprice100g = sellingprice100g;
        this.buyingprice100g = buyingprice100g;
        this.harvestdate = harvestdate;
        this.category = category;
        super.setId(uuid);
    }

    public Product(long nummber, String description, Country country, Double sellingprice100g, Double buyingprice100g, Date harvestdate, Category category) {
        this.nummber = nummber;
        this.description = description;
        this.country = country;
        this.sellingprice100g = sellingprice100g;
        this.buyingprice100g = buyingprice100g;
        this.harvestdate = harvestdate;
        this.category = category;
    }

    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getNummber() {
        return nummber;
    }

    public void setNummber(long nummber) {
        this.nummber = nummber;
    }
}
