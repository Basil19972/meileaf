package com.example.jwt.domain.product;

import com.example.jwt.domain.product.dto.ProductDTO;
import com.example.jwt.domain.product.dto.ProductMapper;
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
@RequestMapping("/products")
public class ProdukteController {


    private final ProduktService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProdukteController(ProductServiceImpl productServiceImpl, ProductMapper productMapper) {
        this.productService = productServiceImpl;
        this.productMapper = productMapper;
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<List<ProductDTO>> findAll() {

        List<ProductDTO> productDTOS = productMapper.toDTOs(productService.findAll());

        return new ResponseEntity<>(productDTOS, HttpStatus.OK);

    }

}
