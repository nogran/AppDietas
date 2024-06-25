package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.CreateFoodRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.FoodResponseDTO;
import com.nogran.app.dietas.api.domain.model.Food;
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
public class FoodMapperImpl implements FoodMapper {

    @Override
    public Food createRequestToDomain(CreateFoodRequestDTO addDto) {
        if ( addDto == null ) {
            return null;
        }

        Food.FoodBuilder food = Food.builder();

        food.name( addDto.getName() );
        food.company( addDto.getCompany() );
        food.grams( addDto.getGrams() );
        food.carbohydrate( addDto.getCarbohydrate() );
        food.protein( addDto.getProtein() );
        food.fat( addDto.getFat() );
        food.totalCalories( addDto.getTotalCalories() );

        return food.build();
    }

    @Override
    public FoodResponseDTO toResponse(Food model) {
        if ( model == null ) {
            return null;
        }

        FoodResponseDTO foodResponseDTO = new FoodResponseDTO();

        foodResponseDTO.setName( model.getName() );
        foodResponseDTO.setGrams( model.getGrams() );
        foodResponseDTO.setCarbohydrate( model.getCarbohydrate() );
        foodResponseDTO.setProtein( model.getProtein() );
        foodResponseDTO.setFat( model.getFat() );
        foodResponseDTO.setTotalCalories( model.getTotalCalories() );

        return foodResponseDTO;
    }

    @Override
    public List<FoodResponseDTO> toResponse(List<Food> models) {
        if ( models == null ) {
            return null;
        }

        List<FoodResponseDTO> list = new ArrayList<FoodResponseDTO>( models.size() );
        for ( Food food : models ) {
            list.add( toResponse( food ) );
        }

        return list;
    }
}
