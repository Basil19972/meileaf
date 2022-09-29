package com.example.jwt.domain.test_exception.dto;

import com.example.jwt.core.generic.ExtendedMapper;
import com.example.jwt.domain.test_exception.Kunde;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KundeMapper extends ExtendedMapper<Kunde, KundeDTO> {
}

