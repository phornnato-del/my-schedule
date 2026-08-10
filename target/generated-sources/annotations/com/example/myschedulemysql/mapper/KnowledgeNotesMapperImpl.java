package com.example.myschedulemysql.mapper;

import com.example.myschedulemysql.dto.response.KnowledgeNotesResDto;
import com.example.myschedulemysql.entity.KnowledgeNotesEntity;
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
public class KnowledgeNotesMapperImpl implements KnowledgeNotesMapper {

    @Override
    public KnowledgeNotesResDto getById(KnowledgeNotesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        KnowledgeNotesResDto knowledgeNotesResDto = new KnowledgeNotesResDto();

        knowledgeNotesResDto.setCategoryId( entity.getCategoryId() );
        knowledgeNotesResDto.setContent( entity.getContent() );
        knowledgeNotesResDto.setCreatedAt( entity.getCreatedAt() );
        knowledgeNotesResDto.setFavorite( entity.getFavorite() );
        knowledgeNotesResDto.setId( entity.getId() );
        knowledgeNotesResDto.setTags( entity.getTags() );
        knowledgeNotesResDto.setTitle( entity.getTitle() );
        knowledgeNotesResDto.setUpdatedAt( entity.getUpdatedAt() );
        knowledgeNotesResDto.setUserId( entity.getUserId() );

        return knowledgeNotesResDto;
    }

    @Override
    public List<KnowledgeNotesResDto> getAlls(List<KnowledgeNotesEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<KnowledgeNotesResDto> list = new ArrayList<KnowledgeNotesResDto>( entities.size() );
        for ( KnowledgeNotesEntity knowledgeNotesEntity : entities ) {
            list.add( getById( knowledgeNotesEntity ) );
        }

        return list;
    }
}
