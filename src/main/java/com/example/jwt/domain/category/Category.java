package com.example.jwt.domain.category;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.rank.Rank;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "categories")
public class Category extends ExtendedEntity {


    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "min_UserRank_Required_Rank_id", nullable = true)
    private Rank min_UserRank_Required;

    @Column(name = "required_age", nullable = false)
    private int required_age;

    public Category(String name, Rank min_UserRank_Required, int required_age) {
        this.name = name;
        this.min_UserRank_Required = min_UserRank_Required;
        this.required_age = required_age;
    }

    public Category(UUID id, String name, Rank min_UserRank_Required, int required_age) {
        this.name = name;
        this.min_UserRank_Required = min_UserRank_Required;
        this.required_age = required_age;
        super.setId(id);
    }

    public Category() {
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
