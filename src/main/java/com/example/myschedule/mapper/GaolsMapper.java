package com.example.myschedule.mapper;

import com.example.myschedule.dto.response.GoalsResDto;
import com.example.myschedule.entity.GoalsEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface GaolsMapper {
    GoalsResDto getByIntoDto(GoalsEntity goalsEntity);
    List<GoalsResDto> toDto(List<GoalsEntity> entities);
}
