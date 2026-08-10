package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.StatusResDto;
import com.example.myschedulemysql.entity.StatusEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    List<StatusResDto> status(List<StatusEntity> entity);
}
