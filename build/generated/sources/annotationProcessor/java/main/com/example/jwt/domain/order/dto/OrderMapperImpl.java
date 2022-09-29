package com.example.jwt.domain.order.dto;

import com.example.jwt.domain.authority.Authority;
import com.example.jwt.domain.authority.dto.AuthorityDTO;
import com.example.jwt.domain.category.Category;
import com.example.jwt.domain.category.dto.CategoryDTO;
import com.example.jwt.domain.country.Country;
import com.example.jwt.domain.country.dto.CountryDTO;
import com.example.jwt.domain.order.Order;
import com.example.jwt.domain.placeorder.PlaceOrder;
import com.example.jwt.domain.placeorder.dto.PlaceOrderDTO;
import com.example.jwt.domain.product.Product;
import com.example.jwt.domain.product.dto.ProductDTO;
import com.example.jwt.domain.role.Role;
import com.example.jwt.domain.role.dto.RoleDTO;
import com.example.jwt.domain.user.User;
import com.example.jwt.domain.user.dto.UserDTO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-28T09:31:11+0200",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order fromDTO(OrderDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( dto.getId() );
        order.setStatus( dto.getStatus() );
        if ( dto.getDiscount() != null ) {
            order.setDiscount( dto.getDiscount().intValue() );
        }
        order.setAppuser( userDTOToUser( dto.getAppuser() ) );
        order.setTotalPrice( dto.getTotalPrice() );
        order.setPlaceOrders( placeOrderDTOSetToPlaceOrderSet( dto.getPlaceOrders() ) );

        return order;
    }

    @Override
    public List<Order> fromDTOs(List<OrderDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( dtos.size() );
        for ( OrderDTO orderDTO : dtos ) {
            list.add( fromDTO( orderDTO ) );
        }

        return list;
    }

    @Override
    public Set<Order> fromDTOs(Set<OrderDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Order> set = new LinkedHashSet<Order>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( OrderDTO orderDTO : dtos ) {
            set.add( fromDTO( orderDTO ) );
        }

        return set;
    }

    @Override
    public OrderDTO toDTO(Order BO) {
        if ( BO == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( BO.getId() );
        orderDTO.setStatus( BO.getStatus() );
        orderDTO.setDiscount( (long) BO.getDiscount() );
        orderDTO.setAppuser( userToUserDTO( BO.getAppuser() ) );
        orderDTO.setTotalPrice( BO.getTotalPrice() );
        orderDTO.setPlaceOrders( placeOrderSetToPlaceOrderDTOSet( BO.getPlaceOrders() ) );

        return orderDTO;
    }

    @Override
    public List<OrderDTO> toDTOs(List<Order> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( BOs.size() );
        for ( Order order : BOs ) {
            list.add( toDTO( order ) );
        }

        return list;
    }

    @Override
    public Set<OrderDTO> toDTOs(Set<Order> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<OrderDTO> set = new LinkedHashSet<OrderDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( Order order : BOs ) {
            set.add( toDTO( order ) );
        }

        return set;
    }

    protected Authority authorityDTOToAuthority(AuthorityDTO authorityDTO) {
        if ( authorityDTO == null ) {
            return null;
        }

        Authority authority = new Authority();

        authority.setId( authorityDTO.getId() );
        authority.setName( authorityDTO.getName() );

        return authority;
    }

    protected Set<Authority> authorityDTOSetToAuthoritySet(Set<AuthorityDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Authority> set1 = new LinkedHashSet<Authority>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AuthorityDTO authorityDTO : set ) {
            set1.add( authorityDTOToAuthority( authorityDTO ) );
        }

        return set1;
    }

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDTO.getId() );
        role.setName( roleDTO.getName() );
        role.setAuthorities( authorityDTOSetToAuthoritySet( roleDTO.getAuthorities() ) );

        return role;
    }

    protected Set<Role> roleDTOSetToRoleSet(Set<RoleDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new LinkedHashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleDTO roleDTO : set ) {
            set1.add( roleDTOToRole( roleDTO ) );
        }

        return set1;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setFirstName( userDTO.getFirstName() );
        user.setLastName( userDTO.getLastName() );
        user.setEmail( userDTO.getEmail() );
        user.setRoles( roleDTOSetToRoleSet( userDTO.getRoles() ) );

        return user;
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

    protected PlaceOrder placeOrderDTOToPlaceOrder(PlaceOrderDTO placeOrderDTO) {
        if ( placeOrderDTO == null ) {
            return null;
        }

        PlaceOrder placeOrder = new PlaceOrder();

        placeOrder.setId( placeOrderDTO.getId() );
        placeOrder.setQuantity( placeOrderDTO.getQuantity() );
        placeOrder.setProduct( productDTOToProduct( placeOrderDTO.getProduct() ) );

        return placeOrder;
    }

    protected Set<PlaceOrder> placeOrderDTOSetToPlaceOrderSet(Set<PlaceOrderDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<PlaceOrder> set1 = new LinkedHashSet<PlaceOrder>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PlaceOrderDTO placeOrderDTO : set ) {
            set1.add( placeOrderDTOToPlaceOrder( placeOrderDTO ) );
        }

        return set1;
    }

    protected AuthorityDTO authorityToAuthorityDTO(Authority authority) {
        if ( authority == null ) {
            return null;
        }

        AuthorityDTO authorityDTO = new AuthorityDTO();

        authorityDTO.setId( authority.getId() );
        authorityDTO.setName( authority.getName() );

        return authorityDTO;
    }

    protected Set<AuthorityDTO> authoritySetToAuthorityDTOSet(Set<Authority> set) {
        if ( set == null ) {
            return null;
        }

        Set<AuthorityDTO> set1 = new LinkedHashSet<AuthorityDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Authority authority : set ) {
            set1.add( authorityToAuthorityDTO( authority ) );
        }

        return set1;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setName( role.getName() );
        roleDTO.setAuthorities( authoritySetToAuthorityDTOSet( role.getAuthorities() ) );

        return roleDTO;
    }

    protected Set<RoleDTO> roleSetToRoleDTOSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDTO> set1 = new LinkedHashSet<RoleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleDTO( role ) );
        }

        return set1;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setRoles( roleSetToRoleDTOSet( user.getRoles() ) );

        return userDTO;
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

    protected PlaceOrderDTO placeOrderToPlaceOrderDTO(PlaceOrder placeOrder) {
        if ( placeOrder == null ) {
            return null;
        }

        Long quantity = null;
        ProductDTO product = null;

        quantity = placeOrder.getQuantity();
        product = productToProductDTO( placeOrder.getProduct() );

        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO( quantity, product );

        placeOrderDTO.setId( placeOrder.getId() );

        return placeOrderDTO;
    }

    protected Set<PlaceOrderDTO> placeOrderSetToPlaceOrderDTOSet(Set<PlaceOrder> set) {
        if ( set == null ) {
            return null;
        }

        Set<PlaceOrderDTO> set1 = new LinkedHashSet<PlaceOrderDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PlaceOrder placeOrder : set ) {
            set1.add( placeOrderToPlaceOrderDTO( placeOrder ) );
        }

        return set1;
    }
}
