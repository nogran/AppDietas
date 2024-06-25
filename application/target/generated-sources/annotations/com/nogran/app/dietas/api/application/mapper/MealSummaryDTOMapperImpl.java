package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.response.MealSummaryResponseDTO;
import com.nogran.app.dietas.api.domain.dto.MealSummaryDTO;
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
public class MealSummaryDTOMapperImpl implements MealSummaryDTOMapper {

    @Override
    public MealSummaryResponseDTO toResponse(MealSummaryDTO model) {
        if ( model == null ) {
            return null;
        }

        MealSummaryResponseDTO mealSummaryResponseDTO = new MealSummaryResponseDTO();

        return mealSummaryResponseDTO;
    }

    @Override
    public List<MealSummaryResponseDTO> toResponse(List<MealSummaryDTO> models) {
        if ( models == null ) {
            return null;
        }

        List<MealSummaryResponseDTO> list = new ArrayList<MealSummaryResponseDTO>( models.size() );
        for ( MealSummaryDTO mealSummaryDTO : models ) {
            list.add( toResponse( mealSummaryDTO ) );
        }

        return list;
    }
}
