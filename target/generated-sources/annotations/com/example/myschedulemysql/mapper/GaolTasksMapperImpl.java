package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.GoalTasksResDto;
import com.example.myschedulemysql.entity.GoalTasksEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-10T23:21:15+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.100.v20260624-0231, environment: Java 21.0.11 (Eclipse Adoptium)"
)
@Component
public class GaolTasksMapperImpl implements GaolTasksMapper {

    @Override
    public GoalTasksResDto getById(GoalTasksEntity goalTaskEntity) {
        if ( goalTaskEntity == null ) {
            return null;
        }

        GoalTasksResDto goalTasksResDto = new GoalTasksResDto();

        goalTasksResDto.setCompleted( goalTaskEntity.getCompleted() );
        goalTasksResDto.setCreatedAt( goalTaskEntity.getCreatedAt() );
        goalTasksResDto.setDueDate( goalTaskEntity.getDueDate() );
        goalTasksResDto.setGoalId( goalTaskEntity.getGoalId() );
        goalTasksResDto.setId( goalTaskEntity.getId() );
        goalTasksResDto.setTaskName( goalTaskEntity.getTaskName() );
        goalTasksResDto.setUpdatedAt( goalTaskEntity.getUpdatedAt() );
        goalTasksResDto.setUserId( goalTaskEntity.getUserId() );

        return goalTasksResDto;
    }

    @Override
    public List<GoalTasksResDto> getAlls(List<GoalTasksEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<GoalTasksResDto> list = new ArrayList<GoalTasksResDto>( entities.size() );
        for ( GoalTasksEntity goalTasksEntity : entities ) {
            list.add( getById( goalTasksEntity ) );
        }

        return list;
    }
}
