package com.example.myschedulemysql.service;

import com.example.myschedulemysql.dto.request.GoalTasksReqDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.GoalTasksResDto;

import java.io.IOException;
import java.util.List;

public interface GoalTasksService {
    BaseWebResponse<GoalTasksResDto> insert(GoalTasksReqDto request) throws IOException;
    BaseWebResponse<List<GoalTasksResDto>> getAllGoalTask() throws IOException;
    BaseWebResponse<GoalTasksResDto> getAllGoalTaskById(Long id) throws IOException;
    BaseWebResponse<GoalTasksResDto> update(Long id, GoalTasksReqDto request) throws IOException;
    BaseWebResponse<Void> delete(Long id) throws IOException;
}
