package com.example.myschedulemysql.controller;

import com.example.myschedulemysql.dto.request.GoalsReqDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.GoalsResDto;
import com.example.myschedulemysql.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/goals")
@RequiredArgsConstructor
public class GoalsController {
    private final GoalService goalService;

    @GetMapping
    public BaseWebResponse<List<GoalsResDto>> getAllGoals() throws IOException {
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public BaseWebResponse<GoalsResDto> getAllGoalsById(@PathVariable Long id) throws IOException{
        return goalService.getAllGoalsById(id);
    }

    @PostMapping
    public BaseWebResponse<GoalsResDto> insert(@RequestBody GoalsReqDto request) throws IOException{
        return goalService.insert(request);
    }

    @PostMapping("/update/{id}")
    public BaseWebResponse<GoalsResDto> update(@PathVariable  Long id, @RequestBody GoalsReqDto request) throws IOException {
        return goalService.update(id, request);
    }

    @PostMapping("/delete/{id}")
    public BaseWebResponse<Void> delete(@PathVariable Long id) throws IOException {
        return goalService.delete(id);
    }
}
