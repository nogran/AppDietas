package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.CreateUserRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.UserResponseDTO;
import com.nogran.app.dietas.api.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends
    ResponseMapper<User, UserResponseDTO>,
    CreateRequestMapper<User, CreateUserRequestDTO> {

  @Override
  @Mapping(source = "username", target = "login")
  User createRequestToDomain(CreateUserRequestDTO addDto);
}
