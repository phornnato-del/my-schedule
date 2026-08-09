package com.example.myschedule.mapper;

import com.example.myschedule.dto.response.GoalTasksResDto;
import com.example.myschedule.dto.response.GoalsResDto;
import com.example.myschedule.entity.GoalTasksEntity;
import com.example.myschedule.entity.GoalsEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GaolTasksMapper {
    GoalTasksResDto getById(GoalTasksEntity goalTaskEntity);
    List<GoalTasksResDto> getAlls(List<GoalTasksEntity> entities);
}
