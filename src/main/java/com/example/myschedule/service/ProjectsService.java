package com.example.myschedule.service;

import com.example.myschedule.dto.request.GoalsReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.GoalsResDto;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

//@Component
public interface GoalService {
    BaseWebResponse<GoalsResDto> insert(GoalsReqDto request) throws IOException;
    BaseWebResponse<List<GoalsResDto>> getAllGoals() throws IOException;
    BaseWebResponse<GoalsResDto> getAllGoalsById(Long id) throws IOException;
    BaseWebResponse<GoalsResDto> update(Long id, GoalsReqDto request) throws IOException;
    BaseWebResponse<Void> delete(Long id) throws IOException;
}
