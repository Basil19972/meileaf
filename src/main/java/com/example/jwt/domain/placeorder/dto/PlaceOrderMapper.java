package com.example.jwt.domain.placeorder.dto;

import com.example.jwt.core.generic.ExtendedMapper;
import com.example.jwt.domain.placeorder.PlaceOrder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlaceOrderMapper extends ExtendedMapper<PlaceOrder, PlaceOrderDTO> {


}
