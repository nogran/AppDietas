package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.CreateFoodRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.FoodResponseDTO;
import com.nogran.app.dietas.api.domain.model.Food;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodMapper extends
    ResponseMapper<Food, FoodResponseDTO>,
    CreateRequestMapper<Food, CreateFoodRequestDTO> {

}
