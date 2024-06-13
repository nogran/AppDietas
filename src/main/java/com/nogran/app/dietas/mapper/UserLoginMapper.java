package com.nogran.app.dietas.mapper;

import com.nogran.app.dietas.dto.request.CreateUserLoginRequestDTO;
import com.nogran.app.dietas.dto.response.UserLoginResponseDTO;
import com.nogran.app.dietas.entity.UserLoginEntity;
import com.nogran.app.dietas.model.UserLogin;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserLoginMapper {

  UserLoginMapper INSTANCE = Mappers.getMapper(UserLoginMapper.class);

  UserLogin entityToModel(UserLoginEntity entity);

  List<UserLogin> entityToModel(List<UserLoginEntity> entities);

  UserLoginEntity modelToEntity(UserLogin user);

  UserLoginResponseDTO toResponse(UserLogin user);

  List<UserLoginResponseDTO> toResponse(List<UserLogin> users);

  UserLogin createRequestToDomain(CreateUserLoginRequestDTO requestDTO);

}
