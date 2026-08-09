package com.example.myschedule.mapper.User;

import com.example.myschedule.dto.response.user.UserResponseDto;
import com.example.myschedule.entity.UserEntity;
import com.example.myschedule.util.ImageUtil;
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
