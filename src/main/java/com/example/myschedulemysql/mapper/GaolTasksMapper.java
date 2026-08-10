package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.GoalTasksResDto;
import com.example.myschedulemysql.entity.GoalTasksEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GaolTasksMapper {
    GoalTasksResDto getById(GoalTasksEntity goalTaskEntity);
    List<GoalTasksResDto> getAlls(List<GoalTasksEntity> entities);
}
