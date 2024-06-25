package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.UserVerification;
import com.nogran.app.dietas.api.infrastructure.entity.UserVerificationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserVerificationEntityMapper extends
    BaseMapper<UserVerification, UserVerificationEntity> {

}
