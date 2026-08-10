package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.GoalsResDto;
import com.example.myschedulemysql.entity.GoalsEntity;
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
public class GaolsMapperImpl implements GaolsMapper {

    @Override
    public GoalsResDto getByIntoDto(GoalsEntity goalsEntity) {
        if ( goalsEntity == null ) {
            return null;
        }

        GoalsResDto goalsResDto = new GoalsResDto();

        goalsResDto.setCategoryId( goalsEntity.getCategoryId() );
        goalsResDto.setCreatedAt( goalsEntity.getCreatedAt() );
        goalsResDto.setDescription( goalsEntity.getDescription() );
        goalsResDto.setId( goalsEntity.getId() );
        goalsResDto.setPriorityId( goalsEntity.getPriorityId() );
        goalsResDto.setProgress( goalsEntity.getProgress() );
        goalsResDto.setStartDate( goalsEntity.getStartDate() );
        goalsResDto.setStatusId( goalsEntity.getStatusId() );
        goalsResDto.setTargetDate( goalsEntity.getTargetDate() );
        goalsResDto.setTitle( goalsEntity.getTitle() );
        goalsResDto.setUpdatedAt( goalsEntity.getUpdatedAt() );
        goalsResDto.setUserId( goalsEntity.getUserId() );

        return goalsResDto;
    }

    @Override
    public List<GoalsResDto> toDto(List<GoalsEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<GoalsResDto> list = new ArrayList<GoalsResDto>( entities.size() );
        for ( GoalsEntity goalsEntity : entities ) {
            list.add( getByIntoDto( goalsEntity ) );
        }

        return list;
    }
}
