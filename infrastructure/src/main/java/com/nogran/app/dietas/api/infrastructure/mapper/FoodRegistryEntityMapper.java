package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.FoodRegistry;
import com.nogran.app.dietas.api.infrastructure.entity.FoodRegistryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodRegistryEntityMapper extends
    BaseMapper<FoodRegistry, FoodRegistryEntity> {

}
