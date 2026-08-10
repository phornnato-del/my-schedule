package com.example.myschedulemysql.service.impl;

import com.example.myschedulemysql.dao.CategoryDao;
import com.example.myschedulemysql.dao.PriorityDao;
import com.example.myschedulemysql.dao.StatusDao;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.CategoryResDto;
import com.example.myschedulemysql.dto.response.PriorityResDto;
import com.example.myschedulemysql.dto.response.StatusResDto;
import com.example.myschedulemysql.entity.CategoryEntity;
import com.example.myschedulemysql.entity.PriorityEntity;
import com.example.myschedulemysql.entity.StatusEntity;
import com.example.myschedulemysql.exception.ApiException;
import com.example.myschedulemysql.mapper.CategoryMapper;
import com.example.myschedulemysql.mapper.ErrorMapper;
import com.example.myschedulemysql.mapper.PriorityMapper;
import com.example.myschedulemysql.mapper.StatusMapper;
import com.example.myschedulemysql.service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final StatusDao statusDao;
    private final PriorityDao priorityDao;
    private final CategoryDao categoryDao;

    private final PriorityMapper priorityMapper;
    private final StatusMapper statusMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public BaseWebResponse<List<StatusResDto>> getStatus() throws IOException {

        try {
            List<StatusEntity> entity = statusDao.findAll();
            List<StatusResDto> data = statusMapper.status(entity);

            return BaseWebResponse.<List<StatusResDto>>builder()
                    .status(200)
                    .message("Status retrieved successfully !")
                    .data(data)
                    .build();

        }catch (Exception e){
            throw new ApiException(new ErrorMapper(500, "failed " + e.getMessage()));
        }

    }

    @Override
    public BaseWebResponse<List<PriorityResDto>> getPriority() throws IOException {
        try {
            List<PriorityEntity> entity = priorityDao.findAll();
            List<PriorityResDto> data = priorityMapper.priority(entity);

            return BaseWebResponse.<List<PriorityResDto>>builder()
                    .status(200)
                    .message("Priority retrieved successfully !")
                    .data(data)
                    .build();

        }catch (Exception e){
            throw new ApiException(new ErrorMapper(500, "failed " + e.getMessage()));
        }
    }

    @Override
    public BaseWebResponse<List<CategoryResDto>> getCategories(String type) throws IOException {
        try {

            List<CategoryEntity> entity = Objects.isNull(type)
                    ? categoryDao.findAll()
                    : categoryDao.findByType(type);

            List<CategoryResDto> data = categoryMapper.category(entity);

            return BaseWebResponse.<List<CategoryResDto>>builder()
                    .status(200)
                    .message("Category retrieved successfully !")
                    .data(data)
                    .build();

        }catch (Exception e){
            throw new ApiException(new ErrorMapper(500, "failed " + e.getMessage()));
        }
    }
}

