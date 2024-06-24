package com.nogran.app.dietas.api.infrastructure.mapper;

import com.nogran.app.dietas.api.domain.model.User;
import com.nogran.app.dietas.api.infrastructure.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T19:06:00-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class UserEntityMapperImpl implements UserEntityMapper {

    @Override
    public List<UserEntity> toEntity(List<User> models) {
        if ( models == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( models.size() );
        for ( User user : models ) {
            list.add( toEntity( user ) );
        }

        return list;
    }

    @Override
    public List<User> toDomain(List<UserEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( entities.size() );
        for ( UserEntity userEntity : entities ) {
            list.add( toDomain( userEntity ) );
        }

        return list;
    }

    @Override
    public void update(UserEntity entity, User model) {
        if ( model == null ) {
            return;
        }

        entity.setName( model.getName() );
        entity.setEmail( model.getEmail() );
        entity.setLogin( model.getLogin() );
        entity.setPassword( model.getPassword() );
        entity.setBirthDate( model.getBirthDate() );
        entity.setWeight( model.getWeight() );
        entity.setHeight( model.getHeight() );
        entity.setGender( model.getGender() );
    }

    @Override
    public User toDomain(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User user = new User();

        user.setStatus( entity.getUserStatus() );
        user.setName( entity.getName() );
        user.setEmail( entity.getEmail() );
        user.setLogin( entity.getLogin() );
        user.setPassword( entity.getPassword() );
        user.setBirthDate( entity.getBirthDate() );
        user.setWeight( entity.getWeight() );
        user.setHeight( entity.getHeight() );
        user.setGender( entity.getGender() );

        return user;
    }

    @Override
    public UserEntity toEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserStatus( user.getStatus() );
        userEntity.setName( user.getName() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setLogin( user.getLogin() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setBirthDate( user.getBirthDate() );
        userEntity.setWeight( user.getWeight() );
        userEntity.setHeight( user.getHeight() );
        userEntity.setGender( user.getGender() );

        return userEntity;
    }
}
