package com.example.myschedulemysql.service;

import com.example.myschedulemysql.dto.request.GoalsReqDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.GoalsResDto;

import java.io.IOException;
import java.util.List;

//@Component
public interface GoalService {
    BaseWebResponse<GoalsResDto> insert(GoalsReqDto request) throws IOException;
    BaseWebResponse<List<GoalsResDto>> getAllGoals() throws IOException;
    BaseWebResponse<GoalsResDto> getAllGoalsById(Long id) throws IOException;
    BaseWebResponse<GoalsResDto> update(Long id, GoalsReqDto request) throws IOException;
    BaseWebResponse<Void> delete(Long id) throws IOException;
}
