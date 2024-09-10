package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.UserMacro;
import com.nogran.app.dietas.api.infrastructure.entity.UserMacroEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMacroEntityMapper extends
    BaseMapper<UserMacro, UserMacroEntity> {

}
