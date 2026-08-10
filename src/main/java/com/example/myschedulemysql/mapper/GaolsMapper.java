package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.GoalsResDto;
import com.example.myschedulemysql.entity.GoalsEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GaolsMapper {
    GoalsResDto getByIntoDto(GoalsEntity goalsEntity);
    List<GoalsResDto> toDto(List<GoalsEntity> entities);
}
