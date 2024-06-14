package com.nogran.app.dietas.mapper;

import com.nogran.app.dietas.dto.AccessDTO;
import com.nogran.app.dietas.dto.UserDTO;
import com.nogran.app.dietas.dto.request.AuthRequestDTO;
import com.nogran.app.dietas.dto.request.CreateUserRequestDTO;
import com.nogran.app.dietas.dto.response.UserResponseDTO;
import com.nogran.app.dietas.entity.UserEntity;
import com.nogran.app.dietas.model.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User entityToModel(UserEntity entity);

  List<User> entityToModel(List<UserEntity> entities);

  @Mapping(target = "login", source = "username")
  UserEntity modelToEntity(User user);

  UserResponseDTO toResponse(User user);

  List<UserResponseDTO> toResponse(List<User> users);

  User createRequestToDomain(CreateUserRequestDTO requestDTO);

  UserDTO createRequestToDomain(AuthRequestDTO requestDTO);

  UserResponseDTO toResponse(AccessDTO accessDTO);

}
