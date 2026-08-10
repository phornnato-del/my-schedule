package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.KnowledgeNotesResDto;
import com.example.myschedulemysql.entity.KnowledgeNotesEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KnowledgeNotesMapper {
    KnowledgeNotesResDto getById(KnowledgeNotesEntity entity);
    List<KnowledgeNotesResDto> getAlls(List<KnowledgeNotesEntity> entities);
}
