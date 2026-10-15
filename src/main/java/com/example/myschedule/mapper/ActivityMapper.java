package com.example.myschedule.mapper;

import com.example.myschedule.dto.response.ActivitiesResDto;
import com.example.myschedule.entity.ActivitiesEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivitiesResDto getByIntoDto(ActivitiesEntity entity);
    List<ActivitiesResDto> toDto(List<ActivitiesEntity> entities);
}
