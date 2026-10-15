package com.example.myschedule.service.impl;

import com.example.myschedule.dao.ProjectDao;
import com.example.myschedule.dao.ProjectTasksDao;
import com.example.myschedule.dto.request.ProjectTasksReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.ProjectTasksResDto;
import com.example.myschedule.entity.ProjectTasksEntity;
import com.example.myschedule.enums.StatusEnum;
import com.example.myschedule.exception.ApiException;
import com.example.myschedule.mapper.ProjectTaskMapper;
import com.example.myschedule.service.ProjectsTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProjectTasksServiceImp implements ProjectsTaskService {

    private final ProjectTasksDao projectDao;
    private final ProjectTaskMapper projectTaskMapper;

    @Override
    public BaseWebResponse<ProjectTasksResDto> insert(ProjectTasksReqDto request) throws IOException {

       try{
           ProjectTasksEntity goals = mapToEntity(request, null);
           projectDao.saveEntity(goals);

           return BaseWebResponse.<ProjectTasksResDto>builder()
                   .status(StatusEnum.SUCCESS.getCode())
                   .message("Projects tasks created successfully !")
                   .build();
       }catch (ApiException e){
           throw e;
       }catch(Exception e){
           throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
       }
    }

    @Override
    public BaseWebResponse<List<ProjectTasksResDto>> getAllProjectTask() throws IOException {

        try{
            List<ProjectTasksEntity> entity = projectDao.findAll();
            List<ProjectTasksResDto> data = projectTaskMapper.toDto(entity);

            return BaseWebResponse.<List<ProjectTasksResDto>>builder()
                    .status(StatusEnum.SUCCESS.getCode())
                    .message("Retrieved Projects task successfully !")
                    .data(data)
                    .build();
        }catch (ApiException e){
            throw e;
        }catch(Exception e){
            throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    @Override
    public BaseWebResponse<ProjectTasksResDto> getAllProjectTaskById(Long id) throws IOException {

        try {
            ProjectTasksEntity entity = projectDao.findById(id)
                    .orElseThrow(() -> new ApiException(StatusEnum.NOT_FOUND.getCode(), "Project tasks not found " + id));

            ProjectTasksResDto data = projectTaskMapper.getByIntoDto(entity);

            return BaseWebResponse.<ProjectTasksResDto>builder()
                    .status(StatusEnum.SUCCESS.getCode())
                    .message("Retrieved Project tasks successfully !")
                    .data(data)
                    .build();
        }catch (ApiException e){
            throw e;
        }
        catch (Exception e){
            throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    @Override
    public BaseWebResponse<ProjectTasksResDto> update(Long id, ProjectTasksReqDto request) throws IOException {
        try{
            ProjectTasksEntity goals = mapToEntity(request, id);
            projectDao.saveEntity(goals);

            return BaseWebResponse.<ProjectTasksResDto>builder()
                    .status(StatusEnum.SUCCESS.getCode())
                    .message(" Project tasks updated successfully !")
                    .build();

        }catch (ApiException e){
            throw e;
        }catch (Exception e){
                throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
            }
        }

    @Override
    public BaseWebResponse<Void> delete(Long id) throws IOException {
        try {
            ProjectTasksEntity entity = projectDao.findById(id)
                    .orElseThrow(() ->  new ApiException(StatusEnum.NOT_FOUND.getCode(), "Project tasks not found " + id));

            projectDao.deleteById(id);

            return BaseWebResponse.<Void>builder()
                    .status(StatusEnum.SUCCESS.getCode())
                    .message("Projects tasks deleted successfully !")
                    .build();
        }catch (ApiException e){
            throw e;
        }catch (Exception e){
            throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }

    }

    private ProjectTasksEntity mapToEntity(ProjectTasksReqDto request, Long id){
        try{
            ProjectTasksEntity tasks = Objects.nonNull(id)
                    ? projectDao.findById(id)
                    .orElseThrow(() ->  new ApiException(StatusEnum.NOT_FOUND.getCode(), "Project tasks not found " + id))
                    : new ProjectTasksEntity();

            tasks.setUserId(request.getUserId());
            tasks.setProjectId(request.getProjectId());
            tasks.setTitle(request.getTitle());
            tasks.setDescription(request.getDescription());
            tasks.setProjectId(request.getProjectId());
            tasks.setStatusId(request.getStatusId());
            tasks.setDueDate(request.getDueDate());

            if(Objects.isNull(id)){
                tasks.setCreatedAt(LocalDate.now());
            }else {
                tasks.setUpdatedAt(LocalDate.now());
            }

            return tasks;
        }catch (ApiException e){
            throw e;
        }catch (Exception e){
            throw new ApiException(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }
    }
}
