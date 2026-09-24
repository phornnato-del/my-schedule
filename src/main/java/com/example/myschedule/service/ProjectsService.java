package com.example.myschedule.service;

import com.example.myschedule.dto.request.GoalsReqDto;
import com.example.myschedule.dto.request.ProjectsReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.GoalsResDto;
import com.example.myschedule.dto.response.ProjectsResDto;

import java.io.IOException;
import java.util.List;

//@Component
public interface ProjectsService {
    BaseWebResponse<ProjectsResDto> insert(ProjectsReqDto request) throws IOException;
    BaseWebResponse<List<ProjectsResDto>> getAllProjects() throws IOException;
    BaseWebResponse<ProjectsResDto> getAllProjectById(Long id) throws IOException;
    BaseWebResponse<ProjectsResDto> update(Long id, ProjectsReqDto request) throws IOException;
    BaseWebResponse<Void> delete(Long id) throws IOException;
}
