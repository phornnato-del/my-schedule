package com.example.myschedule.mapper;

import com.example.myschedule.dto.response.ProjectsResDto;
import com.example.myschedule.entity.ProjectsEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectsResDto getByIntoDto(ProjectsEntity entity);
    List<ProjectsResDto> toDto(List<ProjectsEntity> entities);
}
