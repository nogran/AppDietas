package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.AuthRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.AccessResponseDTO;
import com.nogran.app.dietas.api.domain.dto.AccessDTO;
import com.nogran.app.dietas.api.domain.dto.AuthenticationDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T19:05:58-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public AuthenticationDTO createRequestToDomain(AuthRequestDTO addDto) {
        if ( addDto == null ) {
            return null;
        }

        String username = null;
        String password = null;

        username = addDto.getUsername();
        password = addDto.getPassword();

        AuthenticationDTO authenticationDTO = new AuthenticationDTO( username, password );

        return authenticationDTO;
    }

    @Override
    public AccessResponseDTO toResponse(AccessDTO model) {
        if ( model == null ) {
            return null;
        }

        AccessResponseDTO accessResponseDTO = new AccessResponseDTO();

        accessResponseDTO.setToken( model.getToken() );

        return accessResponseDTO;
    }

    @Override
    public List<AccessResponseDTO> toResponse(List<AccessDTO> models) {
        if ( models == null ) {
            return null;
        }

        List<AccessResponseDTO> list = new ArrayList<AccessResponseDTO>( models.size() );
        for ( AccessDTO accessDTO : models ) {
            list.add( toResponse( accessDTO ) );
        }

        return list;
    }
}
