package com.example.jwt.domain.test_exception.dto;

import com.example.jwt.domain.test_exception.Kunde;
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
public class KundeMapperImpl implements KundeMapper {

    @Override
    public Kunde fromDTO(KundeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Kunde kunde = new Kunde();

        kunde.setId( dto.getId() );
        kunde.setName( dto.getName() );
        kunde.setEmail( dto.getEmail() );
        kunde.setAhv( dto.getAhv() );

        return kunde;
    }

    @Override
    public List<Kunde> fromDTOs(List<KundeDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Kunde> list = new ArrayList<Kunde>( dtos.size() );
        for ( KundeDTO kundeDTO : dtos ) {
            list.add( fromDTO( kundeDTO ) );
        }

        return list;
    }

    @Override
    public Set<Kunde> fromDTOs(Set<KundeDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Kunde> set = new LinkedHashSet<Kunde>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( KundeDTO kundeDTO : dtos ) {
            set.add( fromDTO( kundeDTO ) );
        }

        return set;
    }

    @Override
    public KundeDTO toDTO(Kunde BO) {
        if ( BO == null ) {
            return null;
        }

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId( BO.getId() );
        kundeDTO.setName( BO.getName() );
        kundeDTO.setEmail( BO.getEmail() );
        kundeDTO.setAhv( BO.getAhv() );

        return kundeDTO;
    }

    @Override
    public List<KundeDTO> toDTOs(List<Kunde> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<KundeDTO> list = new ArrayList<KundeDTO>( BOs.size() );
        for ( Kunde kunde : BOs ) {
            list.add( toDTO( kunde ) );
        }

        return list;
    }

    @Override
    public Set<KundeDTO> toDTOs(Set<Kunde> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<KundeDTO> set = new LinkedHashSet<KundeDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( Kunde kunde : BOs ) {
            set.add( toDTO( kunde ) );
        }

        return set;
    }
}
