package com.example.jwt.domain.placeorder.dto;

import com.example.jwt.domain.category.Category;
import com.example.jwt.domain.category.dto.CategoryDTO;
import com.example.jwt.domain.country.Country;
import com.example.jwt.domain.country.dto.CountryDTO;
import com.example.jwt.domain.placeorder.PlaceOrder;
import com.example.jwt.domain.product.Product;
import com.example.jwt.domain.product.dto.ProductDTO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-04T16:11:30+0200",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class PlaceOrderMapperImpl implements PlaceOrderMapper {

    @Override
    public PlaceOrder fromDTO(PlaceOrderDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PlaceOrder placeOrder = new PlaceOrder();

        placeOrder.setId( dto.getId() );
        placeOrder.setQuantity( dto.getQuantity() );
        placeOrder.setProduct( productDTOToProduct( dto.getProduct() ) );

        return placeOrder;
    }

    @Override
    public List<PlaceOrder> fromDTOs(List<PlaceOrderDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<PlaceOrder> list = new ArrayList<PlaceOrder>( dtos.size() );
        for ( PlaceOrderDTO placeOrderDTO : dtos ) {
            list.add( fromDTO( placeOrderDTO ) );
        }

        return list;
    }

    @Override
    public Set<PlaceOrder> fromDTOs(Set<PlaceOrderDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<PlaceOrder> set = new LinkedHashSet<PlaceOrder>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( PlaceOrderDTO placeOrderDTO : dtos ) {
            set.add( fromDTO( placeOrderDTO ) );
        }

        return set;
    }

    @Override
    public PlaceOrderDTO toDTO(PlaceOrder BO) {
        if ( BO == null ) {
            return null;
        }

        Long quantity = null;
        ProductDTO product = null;

        quantity = BO.getQuantity();
        product = productToProductDTO( BO.getProduct() );

        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO( quantity, product );

        placeOrderDTO.setId( BO.getId() );

        return placeOrderDTO;
    }

    @Override
    public List<PlaceOrderDTO> toDTOs(List<PlaceOrder> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<PlaceOrderDTO> list = new ArrayList<PlaceOrderDTO>( BOs.size() );
        for ( PlaceOrder placeOrder : BOs ) {
            list.add( toDTO( placeOrder ) );
        }

        return list;
    }

    @Override
    public Set<PlaceOrderDTO> toDTOs(Set<PlaceOrder> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<PlaceOrderDTO> set = new LinkedHashSet<PlaceOrderDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( PlaceOrder placeOrder : BOs ) {
            set.add( toDTO( placeOrder ) );
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

    protected Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setCountry( countryDTOToCountry( productDTO.getCountry() ) );
        product.setSellingprice100g( productDTO.getSellingprice100g() );
        product.setBuyingprice100g( productDTO.getBuyingprice100g() );
        product.setHarvestdate( productDTO.getHarvestdate() );
        product.setCategory( categoryDTOToCategory( productDTO.getCategory() ) );

        return product;
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

    protected ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setCountry( countryToCountryDTO( product.getCountry() ) );
        productDTO.setSellingprice100g( product.getSellingprice100g() );
        productDTO.setBuyingprice100g( product.getBuyingprice100g() );
        productDTO.setHarvestdate( product.getHarvestdate() );
        productDTO.setCategory( categoryToCategoryDTO( product.getCategory() ) );

        return productDTO;
    }
}
