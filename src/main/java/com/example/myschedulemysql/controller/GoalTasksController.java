package com.example.myschedulemysql.controller;

import com.example.myschedulemysql.dto.request.GoalTasksReqDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.GoalTasksResDto;
import com.example.myschedulemysql.service.GoalTasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/goal-tasks")
@RequiredArgsConstructor
public class GoalTasksController {

    private final GoalTasksService goalTasksService;

    @GetMapping
    public BaseWebResponse<List<GoalTasksResDto>> getAllGoalTask() throws IOException {
        return goalTasksService.getAllGoalTask();
    }

    @GetMapping("/{id}")
    public BaseWebResponse<GoalTasksResDto> getAllGoalTaskById(@PathVariable Long id) throws IOException{
        return goalTasksService.getAllGoalTaskById(id);
    }

    @PostMapping
    public BaseWebResponse<GoalTasksResDto> insert(@RequestBody GoalTasksReqDto request) throws IOException{
        return goalTasksService.insert(request);
    }

    @PostMapping("/update/{id}")
    public BaseWebResponse<GoalTasksResDto> update(@PathVariable  Long id, @RequestBody GoalTasksReqDto request) throws IOException {
        return goalTasksService.update(id, request);
    }

    @PostMapping("/delete/{id}")
    public BaseWebResponse<Void> delete(@PathVariable Long id) throws IOException {
        return goalTasksService.delete(id);
    }
}
