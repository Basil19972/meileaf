package com.example.jwt.domain.rank;

import com.example.jwt.core.generic.ExtendedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Rank extends ExtendedEntity {

    @Column(name = "rankname", nullable = true)
    private String rankname;

    @Column(name = "discountInPercent", nullable = true)
    private int discountInPercent;

    @Column(name = "neededSeedForRank", nullable = true)
    private int neededSeedForRank;

    @Column(name = "defaultRank", nullable = true)
    private boolean defaultRank;

    public Rank(UUID id,String rankname, int discountInPercent, int neededSeedForRank, boolean defaultRank) {
        this.rankname = rankname;
        this.discountInPercent = discountInPercent;
        this.neededSeedForRank = neededSeedForRank;
        this.defaultRank = defaultRank;
        super.setId(id);
    }


    public Rank(String rankname, int discountInPercent, int neededSeedForRank, boolean defaultRank) {
        this.rankname = rankname;
        this.discountInPercent = discountInPercent;

        this.neededSeedForRank = neededSeedForRank;
        this.defaultRank = defaultRank;
    }

    public Rank() {
    }

    public String getRankname() {
        return rankname;
    }

    public void setRankname(String rankname) {
        this.rankname = rankname;
    }

    public int getDiscountInPercent() {
        return discountInPercent;
    }

    public void setDiscountInPercent(int discountInPercent) {
        this.discountInPercent = discountInPercent;
    }

    public int getNeededSeedForRank() {
        return neededSeedForRank;
    }

    public void setNeededSeedForRank(int neededSeedForRank) {
        this.neededSeedForRank = neededSeedForRank;
    }

    public boolean isDefaultRank() {
        return defaultRank;
    }

    public void setDefaultRank(boolean defaultRank) {
        this.defaultRank = defaultRank;
    }
}
