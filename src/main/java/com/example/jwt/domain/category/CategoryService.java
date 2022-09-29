package com.example.jwt.domain.category;

import com.example.jwt.core.generic.ExtendedService;
import com.example.jwt.domain.category.dto.CategoryNameWhitCountDTO;

import java.util.List;

public interface CategoryService extends ExtendedService<Category> {

    List<CategoryNameWhitCountDTO[]> findCategoryWhitCountFromUser();

}
