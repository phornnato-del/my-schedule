package com.example.myschedule.service;

import com.example.myschedule.dto.request.GoalTasksReqDto;
import com.example.myschedule.dto.request.GoalsReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.GoalTasksResDto;
import com.example.myschedule.dto.response.GoalsResDto;

import java.io.IOException;
import java.util.List;

public interface GoalTasksService {
    BaseWebResponse<GoalTasksResDto> insert(GoalTasksReqDto request) throws IOException;
    BaseWebResponse<List<GoalTasksResDto>> getAllGoalTask() throws IOException;
    BaseWebResponse<GoalTasksResDto> getAllGoalTaskById(Long id) throws IOException;
    BaseWebResponse<GoalTasksResDto> update(Long id, GoalTasksReqDto request) throws IOException;
    BaseWebResponse<Void> delete(Long id) throws IOException;
}
