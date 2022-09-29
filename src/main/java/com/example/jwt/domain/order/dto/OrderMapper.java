package com.example.jwt.domain.order.dto;

import com.example.jwt.core.generic.ExtendedMapper;
import com.example.jwt.domain.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper extends ExtendedMapper<Order, OrderDTO> {


}
