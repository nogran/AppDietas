package com.nogran.app.dietas.mapper;

import com.nogran.app.dietas.dto.MealControlDTO;
import com.nogran.app.dietas.dto.MealSummaryDTO;
import com.nogran.app.dietas.dto.request.CreateMealRequestDTO;
import com.nogran.app.dietas.dto.response.MealControlResponseDTO;
import com.nogran.app.dietas.dto.response.MealSummaryResponseDTO;
import com.nogran.app.dietas.model.Meal;
import com.nogran.app.dietas.model.entity.MealEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MealMapper {

  MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);

  List<Meal> entityToModel(List<MealEntity> entities);

  Meal entityToModel(MealEntity entity);

//  MealEntity modelToEntity(MealAggregateDTO mealAggregateDTO);

  MealControlResponseDTO toResponse(MealControlDTO mealControlDTO);

  MealSummaryResponseDTO toResponse(MealSummaryDTO mealSummaryDTO);

//  List<MealSummaryResponseDTO> toResponse(List<MealAggregateDTO> mealAggregateDTOs);

//  MealAggregateDTO createRequestToDomain(CreateMealRequestDTO requestDTO);

}
