package com.example.jwt.domain.rank;

import com.example.jwt.core.generic.ExtendedRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends ExtendedRepository<Rank> {

    @Query(value =
            "SELECT * FROM rank WHERE rank.needed_seed_for_rank <= :seeds ORDER BY rank.needed_seed_for_rank DESC LIMIT 1\n" +
                    "\n", nativeQuery = true)
    Rank getRankBetweenFromSeeds(@Param("seeds") double seeds);


    Rank findRankByDefaultRankIsTrue();




}