package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.Meal;
import com.nogran.app.dietas.api.infrastructure.entity.MealEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealEntityMapper extends
    BaseMapper<Meal, MealEntity> {

}
