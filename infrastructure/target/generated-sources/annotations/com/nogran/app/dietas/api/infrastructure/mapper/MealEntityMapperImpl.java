package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.Meal;
import com.nogran.app.dietas.api.infrastructure.entity.MealEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T19:05:59-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class MealEntityMapperImpl implements MealEntityMapper {

    @Override
    public MealEntity toEntity(Meal model) {
        if ( model == null ) {
            return null;
        }

        MealEntity mealEntity = new MealEntity();

        mealEntity.setMealType( model.getMealType() );
        mealEntity.setReferenceDate( model.getReferenceDate() );

        return mealEntity;
    }

    @Override
    public List<MealEntity> toEntity(List<Meal> models) {
        if ( models == null ) {
            return null;
        }

        List<MealEntity> list = new ArrayList<MealEntity>( models.size() );
        for ( Meal meal : models ) {
            list.add( toEntity( meal ) );
        }

        return list;
    }

    @Override
    public Meal toDomain(MealEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Meal meal = new Meal();

        meal.setMealType( entity.getMealType() );
        meal.setReferenceDate( entity.getReferenceDate() );

        return meal;
    }

    @Override
    public List<Meal> toDomain(List<MealEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Meal> list = new ArrayList<Meal>( entities.size() );
        for ( MealEntity mealEntity : entities ) {
            list.add( toDomain( mealEntity ) );
        }

        return list;
    }

    @Override
    public void update(MealEntity entity, Meal model) {
        if ( model == null ) {
            return;
        }

        entity.setMealType( model.getMealType() );
        entity.setReferenceDate( model.getReferenceDate() );
    }
}
