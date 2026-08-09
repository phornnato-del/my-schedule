package com.example.myschedule.mapper;

import com.example.myschedule.dto.response.CategoryResDto;
import com.example.myschedule.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryResDto> category(List<CategoryEntity> entity);
}
