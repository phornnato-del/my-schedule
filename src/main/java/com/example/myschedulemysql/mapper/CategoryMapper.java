package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.CategoryResDto;
import com.example.myschedulemysql.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryResDto> category(List<CategoryEntity> entity);
}
