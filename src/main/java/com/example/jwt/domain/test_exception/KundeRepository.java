package com.example.jwt.domain.test_exception;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.domain.rank.Rank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KundeRepository extends ExtendedRepository<Kunde> {




}