package com.example.myschedule.controller;

import com.example.myschedule.dto.request.ProjectsReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.ProjectsResDto;
import com.example.myschedule.service.ProjectsService;
import com.example.myschedule.service.crypto.Encrypted;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
@Encrypted
public class ProjectController {

    private final ProjectsService projectsService;

    @GetMapping
    public BaseWebResponse<List<ProjectsResDto>> getAllProjects() throws IOException{
        return projectsService.getAllProjects();
    }

    @GetMapping("/{id}")
    public BaseWebResponse<ProjectsResDto> getProjectById(@PathVariable Long id) throws IOException{
        return projectsService.getAllProjectById(id);
    }

    @PostMapping
    public BaseWebResponse<ProjectsResDto> insert(@RequestBody ProjectsReqDto request) throws IOException {
        return projectsService.insert(request);
    }

    @PostMapping("/update/{id}")
    public  BaseWebResponse<ProjectsResDto> update(@PathVariable Long id, @RequestBody ProjectsReqDto request) throws IOException{
        return projectsService.update(id, request);
    }

    @PostMapping("/delete/{id}")
    public  BaseWebResponse<Void> delete(@PathVariable Long id) throws IOException{
        return projectsService.delete(id);
    }

}