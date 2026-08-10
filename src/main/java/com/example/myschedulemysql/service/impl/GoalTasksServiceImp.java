package com.example.myschedulemysql.service.impl;

import com.example.myschedulemysql.dao.GoalTasksDao;
import com.example.myschedulemysql.dto.request.GoalTasksReqDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.GoalTasksResDto;
import com.example.myschedulemysql.entity.GoalTasksEntity;
import com.example.myschedulemysql.mapper.GaolTasksMapper;
import com.example.myschedulemysql.service.GoalTasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GoalTasksServiceImp implements GoalTasksService {

    private final GoalTasksDao goalTasksDao;
    private final GaolTasksMapper goallTaskMapper;

    @Override
    public BaseWebResponse<GoalTasksResDto> insert(GoalTasksReqDto request) throws IOException {

        GoalTasksEntity goals = mapToEntity(request, null);
        goalTasksDao.saveEntity(goals);

        return BaseWebResponse.<GoalTasksResDto>builder()
                .status(200)
                .message("Goal tasks created successfully !")
                .build();
    }

    @Override
    public BaseWebResponse<List<GoalTasksResDto>> getAllGoalTask() throws IOException {

        List<GoalTasksEntity> entity = goalTasksDao.findAll();
        List<GoalTasksResDto> data = goallTaskMapper.getAlls(entity);

        return BaseWebResponse.<List<GoalTasksResDto>>builder()
                .status(200)
                .message("Retrieved Goal tasks successfully !")
                .data(data)
                .build();
    }

    @Override
    public BaseWebResponse<GoalTasksResDto> getAllGoalTaskById(Long id) throws IOException {

        GoalTasksEntity entity = goalTasksDao.findById(id)
                .orElseThrow(() -> new RuntimeException(" Goal tasks not found with id: " + id));

        GoalTasksResDto data = goallTaskMapper.getById(entity);

        return BaseWebResponse.<GoalTasksResDto>builder()
                .status(200)
                .message("Retrieved Goal Tasks successfully !")
                .data(data)
                .build();
    }

    @Override
    public BaseWebResponse<GoalTasksResDto> update(Long id, GoalTasksReqDto request) throws IOException {
        GoalTasksEntity goals = mapToEntity(request, id);
        goalTasksDao.saveEntity(goals);

        return BaseWebResponse.<GoalTasksResDto>builder()
                .status(200)
                .message("Goal tasks updated successfully !")
                .build();
    }

    @Override
    public BaseWebResponse<Void> delete(Long id) throws IOException {
        GoalTasksEntity entity = goalTasksDao.findById(id)
                .orElseThrow(() -> new RuntimeException(" Goal not found with id: " + id));

        goalTasksDao.deleteById(id);

        return BaseWebResponse.<Void>builder()
                .status(200)
                .message("Goal tasks deleted successfully !")
                .build();

    }

    private GoalTasksEntity mapToEntity(GoalTasksReqDto request, Long id){
        GoalTasksEntity goals = Objects.nonNull(id)
                ? goalTasksDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Goal not found with id: " + id))
                : new GoalTasksEntity();

        goals.setUserId(request.getUserId());
        goals.setGoalId(request.getGoalId());
        goals.setTaskName(request.getTaskName());
        goals.setCompleted(request.getCompleted());
        goals.setDueDate(request.getDueDate());

        if(Objects.isNull(id)){
            goals.setCreatedAt(LocalDate.now());
        }else {
            goals.setUpdatedAt(LocalDate.now());
        }

        return goals;
    }
}
