package com.example.jwt.domain.country.dto;

import com.example.jwt.domain.country.Country;
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
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country fromDTO(CountryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Country country = new Country();

        country.setId( dto.getId() );
        country.setCountryname( dto.getCountryname() );

        return country;
    }

    @Override
    public List<Country> fromDTOs(List<CountryDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Country> list = new ArrayList<Country>( dtos.size() );
        for ( CountryDTO countryDTO : dtos ) {
            list.add( fromDTO( countryDTO ) );
        }

        return list;
    }

    @Override
    public Set<Country> fromDTOs(Set<CountryDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Country> set = new LinkedHashSet<Country>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( CountryDTO countryDTO : dtos ) {
            set.add( fromDTO( countryDTO ) );
        }

        return set;
    }

    @Override
    public CountryDTO toDTO(Country BO) {
        if ( BO == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setId( BO.getId() );
        countryDTO.setCountryname( BO.getCountryname() );

        return countryDTO;
    }

    @Override
    public List<CountryDTO> toDTOs(List<Country> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>( BOs.size() );
        for ( Country country : BOs ) {
            list.add( toDTO( country ) );
        }

        return list;
    }

    @Override
    public Set<CountryDTO> toDTOs(Set<Country> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<CountryDTO> set = new LinkedHashSet<CountryDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( Country country : BOs ) {
            set.add( toDTO( country ) );
        }

        return set;
    }
}
