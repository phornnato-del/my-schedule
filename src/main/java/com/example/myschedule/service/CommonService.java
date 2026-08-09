package com.example.myschedule.service;

import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.CategoryResDto;
import com.example.myschedule.dto.response.PriorityResDto;
import com.example.myschedule.dto.response.StatusResDto;

import java.io.IOException;
import java.util.List;

public interface CommonService {
    BaseWebResponse<List<StatusResDto>> getStatus() throws IOException;
    BaseWebResponse<List<PriorityResDto>> getPriority() throws IOException;
    BaseWebResponse<List<CategoryResDto>> getCategories(String type) throws IOException;
}
