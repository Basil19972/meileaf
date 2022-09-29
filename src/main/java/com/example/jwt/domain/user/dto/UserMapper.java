package com.example.jwt.domain.user.dto;

import com.example.jwt.core.generic.ExtendedMapper;
import com.example.jwt.domain.category.Category;
import com.example.jwt.domain.category.dto.CategoryNameWhitCountDTO;
import com.example.jwt.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends ExtendedMapper<User, UserDTO> {
    User fromUserRegisterDTO(UserRegisterDTO dto);
    User fromUserIdNameAndPriceSpendDTO(UserIdNameAndPriceSpendDTO dto);

}
