package com.example.myschedulemysql.mapper.User;

import com.example.myschedulemysql.dto.response.user.UserResponseDto;
import com.example.myschedulemysql.entity.UserEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-10T23:21:15+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.100.v20260624-0231, environment: Java 21.0.11 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDto toDto(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        String image = null;
        LocalDateTime createdAt = null;
        long id = 0L;
        String status = null;
        String telephone = null;
        String userCode = null;
        String username = null;

        image = toFullImageUrl( user.getImage() );
        createdAt = user.getCreatedAt();
        if ( user.getId() != null ) {
            id = user.getId();
        }
        status = user.getStatus();
        telephone = user.getTelephone();
        userCode = user.getUserCode();
        username = user.getUsername();

        UserResponseDto userResponseDto = new UserResponseDto( id, userCode, username, telephone, status, image, createdAt );

        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> toDto(List<UserEntity> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( users.size() );
        for ( UserEntity userEntity : users ) {
            list.add( toDto( userEntity ) );
        }

        return list;
    }
}
