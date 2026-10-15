package com.example.myschedule.service;

import com.example.myschedule.dto.request.ActivitiesReqDto;
import com.example.myschedule.dto.response.ActivitiesResDto;
import com.example.myschedule.dto.response.BaseWebResponse;

import java.io.IOException;
import java.util.List;

public interface ActivityService {
    BaseWebResponse<ActivitiesResDto> insert(ActivitiesReqDto request) throws IOException;
    BaseWebResponse<List<ActivitiesResDto>> getAllActivities() throws IOException;
    BaseWebResponse<ActivitiesResDto> getAllActivityById(Long id) throws IOException;
    BaseWebResponse<ActivitiesResDto> update(Long id, ActivitiesReqDto request) throws IOException;
    BaseWebResponse<Void> delete(Long id) throws IOException;
}
