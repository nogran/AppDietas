package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.UserMacroRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.UserMacroResponseDTO;
import com.nogran.app.dietas.api.domain.model.UserMacro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMacroMapper extends
    ResponseMapper<UserMacro, UserMacroResponseDTO>,
    CreateRequestMapper<UserMacro, UserMacroRequestDTO> {

}
