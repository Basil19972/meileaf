package com.example.jwt.domain.rank;

import com.example.jwt.core.generic.ExtendedService;

public interface RankService extends ExtendedService<Rank> {

    Rank getRankBetweenFromSeeds(double newtotalSeeds);
    Rank findRankByDefaultRankIsTrue();

}
