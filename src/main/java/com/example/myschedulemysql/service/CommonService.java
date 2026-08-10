package com.example.myschedulemysql.service;

import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.CategoryResDto;
import com.example.myschedulemysql.dto.response.PriorityResDto;
import com.example.myschedulemysql.dto.response.StatusResDto;

import java.io.IOException;
import java.util.List;

public interface CommonService {
    BaseWebResponse<List<StatusResDto>> getStatus() throws IOException;
    BaseWebResponse<List<PriorityResDto>> getPriority() throws IOException;
    BaseWebResponse<List<CategoryResDto>> getCategories(String type) throws IOException;
}
