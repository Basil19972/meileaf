package com.example.jwt.domain.country;

import com.example.jwt.core.generic.ExtendedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends ExtendedEntity {

    private String countryname;

    public Country(String countryname) {
        this.countryname = countryname;
    }

    public Country() {
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}
