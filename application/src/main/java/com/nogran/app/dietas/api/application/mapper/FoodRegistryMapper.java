package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.CreateFoodRegistryRequestDTO;
import com.nogran.app.dietas.api.application.dto.request.CreateFoodRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.FoodRegistryResponseDTO;
import com.nogran.app.dietas.api.application.dto.response.FoodRegistrySummaryResponseDTO;
import com.nogran.app.dietas.api.domain.dto.CreateFoodRegistryDTO;
import com.nogran.app.dietas.api.domain.dto.FoodRegistrySummaryDTO;
import com.nogran.app.dietas.api.domain.model.FoodRegistry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodRegistryMapper extends
    ResponseMapper<FoodRegistry, FoodRegistryResponseDTO>,
    CreateRequestMapper<CreateFoodRegistryDTO, CreateFoodRegistryRequestDTO> {

  FoodRegistrySummaryResponseDTO toResponse(FoodRegistrySummaryDTO foodRegistrySummaryDTO);
}
