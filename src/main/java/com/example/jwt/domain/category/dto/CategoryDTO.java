package com.example.jwt.domain.category.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.rank.Rank;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


public class CategoryDTO extends ExtendedDTO {
    private String name;

    private Rank min_UserRank_Required;

    private int required_age;

    public CategoryDTO(String name, Rank min_UserRank_Required, int required_age) {
        this.name = name;
        this.min_UserRank_Required = min_UserRank_Required;
        this.required_age = required_age;
    }

    public CategoryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getMin_UserRank_Required() {
        return min_UserRank_Required;
    }

    public void setMin_UserRank_Required(Rank min_UserRank_Required) {
        this.min_UserRank_Required = min_UserRank_Required;
    }

    public int getRequired_age() {
        return required_age;
    }

    public void setRequired_age(int required_age) {
        this.required_age = required_age;
    }
}
