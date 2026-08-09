package com.example.myschedule.mapper;

import com.example.myschedule.dto.response.GoalTasksResDto;
import com.example.myschedule.dto.response.KnowledgeNotesResDto;
import com.example.myschedule.entity.GoalTasksEntity;
import com.example.myschedule.entity.KnowledgeNotesEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KnowledgeNotesMapper {
    KnowledgeNotesResDto getById(KnowledgeNotesEntity entity);
    List<KnowledgeNotesResDto> getAlls(List<KnowledgeNotesEntity> entities);
}
