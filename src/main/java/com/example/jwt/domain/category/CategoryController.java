package com.example.jwt.domain.category;

import com.example.jwt.domain.category.dto.CategoryNameWhitCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('CATEGORY_READ')")
    public ResponseEntity<List<CategoryNameWhitCountDTO[]>> findCategoryWhitCountFromUser() {

        List<CategoryNameWhitCountDTO[]> objects = categoryService.findCategoryWhitCountFromUser();

        return new ResponseEntity<>(objects, HttpStatus.OK);

    }


}
