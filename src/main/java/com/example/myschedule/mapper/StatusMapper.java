package com.example.myschedule.mapper;

import com.example.myschedule.dto.response.StatusResDto;
import com.example.myschedule.entity.StatusEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    List<StatusResDto> status(List<StatusEntity> entity);
}
