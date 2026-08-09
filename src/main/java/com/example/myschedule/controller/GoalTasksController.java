package com.example.myschedule.controller;

import com.example.myschedule.dto.request.GoalTasksReqDto;
import com.example.myschedule.dto.request.GoalsReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.GoalTasksResDto;
import com.example.myschedule.dto.response.GoalsResDto;
import com.example.myschedule.service.GoalService;
import com.example.myschedule.service.GoalTasksService;
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
