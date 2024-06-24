package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.CreateMealRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.MealControlResponseDTO;
import com.nogran.app.dietas.api.domain.dto.MealControlDTO;
import com.nogran.app.dietas.api.domain.dto.MealDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealMapper extends
    ResponseMapper<MealControlDTO, MealControlResponseDTO>,
    CreateRequestMapper<MealDTO, CreateMealRequestDTO> {

}
