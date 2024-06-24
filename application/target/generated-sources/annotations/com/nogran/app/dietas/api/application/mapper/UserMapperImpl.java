package com.nogran.app.dietas.api.application.mapper;

import com.nogran.app.dietas.api.application.dto.request.CreateUserRequestDTO;
import com.nogran.app.dietas.api.application.dto.response.UserResponseDTO;
import com.nogran.app.dietas.api.domain.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T19:05:57-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDTO toResponse(User model) {
        if ( model == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setName( model.getName() );
        userResponseDTO.setEmail( model.getEmail() );

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> toResponse(List<User> models) {
        if ( models == null ) {
            return null;
        }

        List<UserResponseDTO> list = new ArrayList<UserResponseDTO>( models.size() );
        for ( User user : models ) {
            list.add( toResponse( user ) );
        }

        return list;
    }

    @Override
    public User createRequestToDomain(CreateUserRequestDTO addDto) {
        if ( addDto == null ) {
            return null;
        }

        User user = new User();

        user.setLogin( addDto.getUsername() );
        user.setName( addDto.getName() );
        user.setEmail( addDto.getEmail() );
        user.setPassword( addDto.getPassword() );

        return user;
    }
}
