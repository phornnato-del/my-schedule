package com.example.myschedule.mapper;

import com.example.myschedule.dto.response.ProjectTasksResDto;
import com.example.myschedule.entity.ProjectTasksEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectTaskMapper {
    ProjectTasksResDto getByIntoDto(ProjectTasksEntity entity);
    List<ProjectTasksResDto> toDto(List<ProjectTasksEntity> entities);
}
