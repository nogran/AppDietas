package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.AuthRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.AccessResponseDTO;
import com.nogran.app.dietas.api.domain.dto.AccessDTO;
import com.nogran.app.dietas.api.domain.dto.AuthenticationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper extends
    ResponseMapper<AccessDTO, AccessResponseDTO>,
    CreateRequestMapper<AuthenticationDTO, AuthRequestDTO> {

}
