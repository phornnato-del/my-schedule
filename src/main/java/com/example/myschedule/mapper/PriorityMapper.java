package com.example.myschedule.mapper;

import com.example.myschedule.dto.response.PriorityResDto;
import com.example.myschedule.entity.PriorityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriorityMapper {
    List<PriorityResDto> priority(List<PriorityEntity> entity);
}
