package com.example.myschedule.service;

import com.example.myschedule.dto.request.ProjectTasksReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.ProjectTasksResDto;

import java.io.IOException;
import java.util.List;

public interface ProjectsTaskService {
    BaseWebResponse<ProjectTasksResDto> insert(ProjectTasksReqDto request) throws IOException;
    BaseWebResponse<List<ProjectTasksResDto>> getAllProjectTask() throws IOException;
    BaseWebResponse<ProjectTasksResDto> getAllProjectTaskById(Long id) throws IOException;
    BaseWebResponse<ProjectTasksResDto> update(Long id, ProjectTasksReqDto request) throws IOException;
    BaseWebResponse<Void> delete(Long id) throws IOException;
}
