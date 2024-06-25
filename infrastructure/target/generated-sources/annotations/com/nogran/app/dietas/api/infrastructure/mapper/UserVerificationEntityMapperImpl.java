package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.UserVerification;
import com.nogran.app.dietas.api.infrastructure.entity.UserVerificationEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T23:37:22-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class UserVerificationEntityMapperImpl implements UserVerificationEntityMapper {

    @Override
    public UserVerificationEntity toEntity(UserVerification model) {
        if ( model == null ) {
            return null;
        }

        UserVerificationEntity userVerificationEntity = new UserVerificationEntity();

        userVerificationEntity.setUuid( model.getUuid() );
        userVerificationEntity.setExpirationDate( model.getExpirationDate() );
        userVerificationEntity.setCreatedBy( model.getCreatedBy() );
        userVerificationEntity.setCreatedAt( model.getCreatedAt() );

        return userVerificationEntity;
    }

    @Override
    public List<UserVerificationEntity> toEntity(List<UserVerification> models) {
        if ( models == null ) {
            return null;
        }

        List<UserVerificationEntity> list = new ArrayList<UserVerificationEntity>( models.size() );
        for ( UserVerification userVerification : models ) {
            list.add( toEntity( userVerification ) );
        }

        return list;
    }

    @Override
    public UserVerification toDomain(UserVerificationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserVerification userVerification = new UserVerification();

        userVerification.setUuid( entity.getUuid() );
        userVerification.setExpirationDate( entity.getExpirationDate() );
        userVerification.setCreatedBy( entity.getCreatedBy() );
        userVerification.setCreatedAt( entity.getCreatedAt() );

        return userVerification;
    }

    @Override
    public List<UserVerification> toDomain(List<UserVerificationEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserVerification> list = new ArrayList<UserVerification>( entities.size() );
        for ( UserVerificationEntity userVerificationEntity : entities ) {
            list.add( toDomain( userVerificationEntity ) );
        }

        return list;
    }

    @Override
    public void update(UserVerificationEntity entity, UserVerification model) {
        if ( model == null ) {
            return;
        }

        entity.setUuid( model.getUuid() );
        entity.setExpirationDate( model.getExpirationDate() );
        entity.setCreatedBy( model.getCreatedBy() );
        entity.setCreatedAt( model.getCreatedAt() );
    }
}
