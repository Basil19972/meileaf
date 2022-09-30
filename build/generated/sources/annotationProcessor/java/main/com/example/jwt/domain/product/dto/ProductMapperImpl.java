package com.example.jwt.domain.product.dto;

import com.example.jwt.domain.category.Category;
import com.example.jwt.domain.category.dto.CategoryDTO;
import com.example.jwt.domain.country.Country;
import com.example.jwt.domain.country.dto.CountryDTO;
import com.example.jwt.domain.product.Product;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-30T08:48:55+0200",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product fromDTO(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setCountry( countryDTOToCountry( dto.getCountry() ) );
        product.setSellingprice100g( dto.getSellingprice100g() );
        product.setBuyingprice100g( dto.getBuyingprice100g() );
        product.setHarvestdate( dto.getHarvestdate() );
        product.setCategory( categoryDTOToCategory( dto.getCategory() ) );

        return product;
    }

    @Override
    public List<Product> fromDTOs(List<ProductDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( dtos.size() );
        for ( ProductDTO productDTO : dtos ) {
            list.add( fromDTO( productDTO ) );
        }

        return list;
    }

    @Override
    public Set<Product> fromDTOs(Set<ProductDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Product> set = new LinkedHashSet<Product>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( ProductDTO productDTO : dtos ) {
            set.add( fromDTO( productDTO ) );
        }

        return set;
    }

    @Override
    public ProductDTO toDTO(Product BO) {
        if ( BO == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( BO.getId() );
        productDTO.setCountry( countryToCountryDTO( BO.getCountry() ) );
        productDTO.setSellingprice100g( BO.getSellingprice100g() );
        productDTO.setBuyingprice100g( BO.getBuyingprice100g() );
        productDTO.setHarvestdate( BO.getHarvestdate() );
        productDTO.setCategory( categoryToCategoryDTO( BO.getCategory() ) );

        return productDTO;
    }

    @Override
    public List<ProductDTO> toDTOs(List<Product> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( BOs.size() );
        for ( Product product : BOs ) {
            list.add( toDTO( product ) );
        }

        return list;
    }

    @Override
    public Set<ProductDTO> toDTOs(Set<Product> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<ProductDTO> set = new LinkedHashSet<ProductDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( Product product : BOs ) {
            set.add( toDTO( product ) );
        }

        return set;
    }

    protected Country countryDTOToCountry(CountryDTO countryDTO) {
        if ( countryDTO == null ) {
            return null;
        }

        Country country = new Country();

        country.setId( countryDTO.getId() );
        country.setCountryname( countryDTO.getCountryname() );

        return country;
    }

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );
        category.setMin_UserRank_Required( categoryDTO.getMin_UserRank_Required() );
        category.setRequired_age( categoryDTO.getRequired_age() );

        return category;
    }

    protected CountryDTO countryToCountryDTO(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setId( country.getId() );
        countryDTO.setCountryname( country.getCountryname() );

        return countryDTO;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );
        categoryDTO.setMin_UserRank_Required( category.getMin_UserRank_Required() );
        categoryDTO.setRequired_age( category.getRequired_age() );

        return categoryDTO;
    }
}
