package com.example.myschedule.service.impl;

import com.example.myschedule.dao.ProjectDao;
import com.example.myschedule.dto.request.ProjectsReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.ProjectsResDto;
import com.example.myschedule.entity.ProjectsEntity;
import com.example.myschedule.enums.StatusEnum;
import com.example.myschedule.mapper.ProjectMapper;
import com.example.myschedule.service.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImp implements ProjectsService {

    private final ProjectDao projectDao;
    private final ProjectMapper projectMapper;

    @Override
    public BaseWebResponse<ProjectsResDto> insert(ProjectsReqDto request) throws IOException {

        ProjectsEntity goals = mapToEntity(request, null);
        projectDao.saveEntity(goals);

        return BaseWebResponse.<ProjectsResDto>builder()
                .status(StatusEnum.SUCCESS.getCode())
                .message("Projects created successfully !")
                .build();
    }

    @Override
    public BaseWebResponse<List<ProjectsResDto>> getAllProjects() throws IOException {

        List<ProjectsEntity> entity = projectDao.findAll();
        List<ProjectsResDto> data = projectMapper.toDto(entity);

        return BaseWebResponse.<List<ProjectsResDto>>builder()
                .status(StatusEnum.SUCCESS.getCode())
                .message("Retrieved Projects successfully !")
                .data(data)
                .build();
    }

    @Override
    public BaseWebResponse<ProjectsResDto> getAllProjectById(Long id) throws IOException {

        ProjectsEntity entity = projectDao.findById(id)
                .orElseThrow(() -> new RuntimeException(" Projects not found with id: " + id));

        ProjectsResDto data = projectMapper.getByIntoDto(entity);

        return BaseWebResponse.<ProjectsResDto>builder()
                .status(StatusEnum.SUCCESS.getCode())
                .message("Retrieved Projects successfully !")
                .data(data)
                .build();
    }

    @Override
    public BaseWebResponse<ProjectsResDto> update(Long id, ProjectsReqDto request) throws IOException {
        ProjectsEntity goals = mapToEntity(request, id);
        projectDao.saveEntity(goals);

        return BaseWebResponse.<ProjectsResDto>builder()
                .status(StatusEnum.SUCCESS.getCode())
                .message("Projects updated successfully !")
                .build();
    }

    @Override
    public BaseWebResponse<Void> delete(Long id) throws IOException {
        ProjectsEntity entity = projectDao.findById(id)
                .orElseThrow(() -> new RuntimeException(" Projects not found with id: " + id));

        projectDao.deleteById(id);

        return BaseWebResponse.<Void>builder()
                .status(StatusEnum.SUCCESS.getCode())
                .message("Projects deleted successfully !")
                .build();

    }

    private ProjectsEntity mapToEntity(ProjectsReqDto request, Long id){
        ProjectsEntity projects = Objects.nonNull(id)
                ? projectDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Projects not found with id: " + id))
                : new ProjectsEntity();

        projects.setUserId(request.getUserId());
        projects.setName(request.getName());
        projects.setDescription(request.getDescription());
        projects.setTechnology(request.getTechnology());
        projects.setStatus(request.getStatus());
        projects.setStartDate(LocalDate.now());
        projects.setEndDate(LocalDate.now());
        projects.setProgress(request.getProgress());

        if(Objects.isNull(id)){
            projects.setCreatedAt(LocalDate.now());
        }else {
            projects.setUpdatedAt(LocalDate.now());
        }

        return projects;
    }
}
