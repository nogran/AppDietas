package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.CreateMealRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.MealControlResponseDTO;
import com.nogran.app.dietas.api.domain.dto.MealControlDTO;
import com.nogran.app.dietas.api.domain.dto.MealDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T23:37:20-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class MealMapperImpl implements MealMapper {

    @Override
    public MealDTO createRequestToDomain(CreateMealRequestDTO addDto) {
        if ( addDto == null ) {
            return null;
        }

        MealDTO.MealDTOBuilder mealDTO = MealDTO.builder();

        return mealDTO.build();
    }

    @Override
    public MealControlResponseDTO toResponse(MealControlDTO model) {
        if ( model == null ) {
            return null;
        }

        MealControlResponseDTO mealControlResponseDTO = new MealControlResponseDTO();

        return mealControlResponseDTO;
    }

    @Override
    public List<MealControlResponseDTO> toResponse(List<MealControlDTO> models) {
        if ( models == null ) {
            return null;
        }

        List<MealControlResponseDTO> list = new ArrayList<MealControlResponseDTO>( models.size() );
        for ( MealControlDTO mealControlDTO : models ) {
            list.add( toResponse( mealControlDTO ) );
        }

        return list;
    }
}
