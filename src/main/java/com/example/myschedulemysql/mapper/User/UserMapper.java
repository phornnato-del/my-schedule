package com.example.myschedulemysql.mapper.User;

import com.example.myschedulemysql.dto.response.user.UserResponseDto;
import com.example.myschedulemysql.entity.UserEntity;
import com.example.myschedulemysql.util.ImageUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "image", source = "image", qualifiedByName = "toFullImageUrl")
    UserResponseDto toDto(UserEntity user);

    List<UserResponseDto> toDto(List<UserEntity> users);

    @Named("toFullImageUrl")
    default String toFullImageUrl(String imagePath) {
        return ImageUtil.getImage(imagePath);
    }
}
