package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.Food;
import com.nogran.app.dietas.api.infrastructure.entity.FoodEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T23:37:23-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class FoodEntityMapperImpl implements FoodEntityMapper {

    @Override
    public FoodEntity toEntity(Food model) {
        if ( model == null ) {
            return null;
        }

        FoodEntity foodEntity = new FoodEntity();

        foodEntity.setName( model.getName() );
        foodEntity.setGrams( model.getGrams() );
        foodEntity.setCarbohydrate( model.getCarbohydrate() );
        foodEntity.setProtein( model.getProtein() );
        foodEntity.setFat( model.getFat() );
        foodEntity.setTotalCalories( model.getTotalCalories() );

        return foodEntity;
    }

    @Override
    public List<FoodEntity> toEntity(List<Food> models) {
        if ( models == null ) {
            return null;
        }

        List<FoodEntity> list = new ArrayList<FoodEntity>( models.size() );
        for ( Food food : models ) {
            list.add( toEntity( food ) );
        }

        return list;
    }

    @Override
    public Food toDomain(FoodEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Food.FoodBuilder food = Food.builder();

        food.name( entity.getName() );
        food.grams( entity.getGrams() );
        food.carbohydrate( entity.getCarbohydrate() );
        food.protein( entity.getProtein() );
        food.fat( entity.getFat() );
        food.totalCalories( entity.getTotalCalories() );

        return food.build();
    }

    @Override
    public List<Food> toDomain(List<FoodEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Food> list = new ArrayList<Food>( entities.size() );
        for ( FoodEntity foodEntity : entities ) {
            list.add( toDomain( foodEntity ) );
        }

        return list;
    }

    @Override
    public void update(FoodEntity entity, Food model) {
        if ( model == null ) {
            return;
        }

        entity.setName( model.getName() );
        entity.setGrams( model.getGrams() );
        entity.setCarbohydrate( model.getCarbohydrate() );
        entity.setProtein( model.getProtein() );
        entity.setFat( model.getFat() );
        entity.setTotalCalories( model.getTotalCalories() );
    }
}
