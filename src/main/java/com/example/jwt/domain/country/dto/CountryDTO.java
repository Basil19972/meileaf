package com.example.jwt.domain.country.dto;

import com.example.jwt.core.generic.ExtendedDTO;

public class CountryDTO extends ExtendedDTO {
    String countryname;

    public CountryDTO() {
    }

    public CountryDTO(String countryname) {
        this.countryname = countryname;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}
