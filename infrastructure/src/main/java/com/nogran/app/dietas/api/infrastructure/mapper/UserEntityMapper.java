package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.User;
import com.nogran.app.dietas.api.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntityMapper extends
    BaseMapper<User, UserEntity> {

  @Override
  @Mapping(target = "status", source = "userStatus")
  User toDomain(UserEntity entity);

  @Override
  @Mapping(target = "userStatus", source = "status")
  UserEntity toEntity(User user);
}
