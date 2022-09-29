package com.example.jwt.domain.rank;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.core.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl extends ExtendedServiceImpl<Rank> implements RankService {

    @Autowired
    protected RankServiceImpl(ExtendedRepository<Rank> repository) {
        super(repository);
    }


    public Rank getRankBetweenFromSeeds(double newtotalSeeds) {

        return ((RankRepository) super.getRepository()).getRankBetweenFromSeeds(newtotalSeeds);
    }

    @Override
    public Rank findRankByDefaultRankIsTrue() {
        return ((RankRepository) super.getRepository()).findRankByDefaultRankIsTrue();
    }
}
