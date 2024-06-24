package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.Food;
import com.nogran.app.dietas.api.infrastructure.entity.FoodEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodEntityMapper extends
    BaseMapper<Food, FoodEntity> {

}
