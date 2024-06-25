package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.response.MealSummaryResponseDTO;
import com.nogran.app.dietas.api.domain.dto.MealSummaryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealSummaryDTOMapper extends
    ResponseMapper<MealSummaryDTO, MealSummaryResponseDTO> {

}
