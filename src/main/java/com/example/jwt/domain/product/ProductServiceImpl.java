package com.example.jwt.domain.product;

import com.example.jwt.core.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ExtendedServiceImpl<Product> implements ProduktService {


    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }
}
