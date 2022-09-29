package com.example.jwt.domain.category;

import com.example.jwt.core.generic.ExtendedServiceImpl;
import com.example.jwt.domain.category.dto.CategoryNameWhitCountDTO;
import com.example.jwt.domain.user.User;
import com.example.jwt.domain.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ExtendedServiceImpl<Category> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }


    public List<CategoryNameWhitCountDTO[]> findCategoryWhitCountFromUser() {

        //Get User UUID
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = ((UserDetailsImpl) principal).user();

        List<CategoryNameWhitCountDTO[]> object = ((CategoryRepository) super.getRepository()).getCategoryWhitCountFromUser(user.getId());


        return object;
    }

}
