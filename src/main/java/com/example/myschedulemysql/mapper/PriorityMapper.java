package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.PriorityResDto;
import com.example.myschedulemysql.entity.PriorityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriorityMapper {
    List<PriorityResDto> priority(List<PriorityEntity> entity);
}
