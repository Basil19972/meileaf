package com.example.jwt.domain.country.dto;

import com.example.jwt.core.generic.ExtendedMapper;
import com.example.jwt.domain.country.Country;
import com.example.jwt.domain.order.Order;
import com.example.jwt.domain.order.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryMapper extends ExtendedMapper<Country, CountryDTO> {


}
