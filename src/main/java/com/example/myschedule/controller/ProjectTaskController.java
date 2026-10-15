package com.example.myschedule.controller;

import com.example.myschedule.dto.request.ProjectTasksReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.ProjectTasksResDto;
import com.example.myschedule.service.ProjectsTaskService;
import com.example.myschedule.service.crypto.Encrypted;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/project-task")
@RequiredArgsConstructor
//@Encrypted
public class ProjectTaskController {

    private final ProjectsTaskService projectsTaskService;

    @GetMapping
    public BaseWebResponse<List<ProjectTasksResDto>> getAllProjectTask() throws IOException{
        return projectsTaskService.getAllProjectTask();
    }

    @GetMapping("/{id}")
    public BaseWebResponse<ProjectTasksResDto> getAllProjectTaskById(@PathVariable Long id) throws IOException{
        return projectsTaskService.getAllProjectTaskById(id);
    }

    @PostMapping
    public BaseWebResponse<ProjectTasksResDto> insert(@RequestBody ProjectTasksReqDto request) throws IOException {
        return projectsTaskService.insert(request);
    }

    @PostMapping("/update/{id}")
    public  BaseWebResponse<ProjectTasksResDto> update(@PathVariable Long id, @RequestBody ProjectTasksReqDto request) throws IOException{
        return projectsTaskService.update(id, request);
    }

    @PostMapping("/delete/{id}")
    public  BaseWebResponse<Void> delete(@PathVariable Long id) throws IOException{
        return projectsTaskService.delete(id);
    }

}