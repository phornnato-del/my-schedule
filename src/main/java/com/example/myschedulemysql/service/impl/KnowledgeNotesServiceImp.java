package com.example.myschedulemysql.service.impl;

import com.example.myschedulemysql.dao.KnowledgeNotesDao;
import com.example.myschedulemysql.dto.request.KnowledgeNotesReqDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.KnowledgeNotesResDto;
import com.example.myschedulemysql.entity.KnowledgeNotesEntity;
import com.example.myschedulemysql.mapper.KnowledgeNotesMapper;
import com.example.myschedulemysql.service.knowledgeNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class KnowledgeNotesServiceImp implements knowledgeNoteService {

    private final KnowledgeNotesDao knowledgeNotesDao;
    private final KnowledgeNotesMapper knowledgeNotesMapper;

    @Override
    public BaseWebResponse<KnowledgeNotesResDto> insert(KnowledgeNotesReqDto request) throws IOException {

        KnowledgeNotesEntity goals = mapToEntity(request, null);
        knowledgeNotesDao.saveEntity(goals);

        return BaseWebResponse.<KnowledgeNotesResDto>builder()
                .status(200)
                .message("Knowledge notes created successfully !")
                .build();
    }

    @Override
    public BaseWebResponse<List<KnowledgeNotesResDto>> getAll() throws IOException {

        List<KnowledgeNotesEntity> entity = knowledgeNotesDao.findAll();
        List<KnowledgeNotesResDto> data = knowledgeNotesMapper.getAlls(entity);

        return BaseWebResponse.<List<KnowledgeNotesResDto>>builder()
                .status(200)
                .message("Retrieved Knowledge notes successfully !")
                .data(data)
                .build();
    }

    @Override
    public BaseWebResponse<KnowledgeNotesResDto> getById(Long id) throws IOException {

        KnowledgeNotesEntity entity = knowledgeNotesDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Knowledge note not found with id: " + id));

        KnowledgeNotesResDto data = knowledgeNotesMapper.getById(entity);

        return BaseWebResponse.<KnowledgeNotesResDto>builder()
                .status(200)
                .message("Retrieved Knowledge notes successfully !")
                .data(data)
                .build();
    }

    @Override
    public BaseWebResponse<KnowledgeNotesResDto> update(Long id, KnowledgeNotesReqDto request) throws IOException {
        KnowledgeNotesEntity goals = mapToEntity(request, id);
        knowledgeNotesDao.saveEntity(goals);

        return BaseWebResponse.<KnowledgeNotesResDto>builder()
                .status(200)
                .message("Knowledge note updated successfully !")
                .build();
    }

    @Override
    public BaseWebResponse<Void> delete(Long id) throws IOException {
        KnowledgeNotesEntity entity = knowledgeNotesDao.findById(id)
                .orElseThrow(() -> new RuntimeException(" Knowledge notes not found with id: " + id));

        knowledgeNotesDao.deleteById(id);

        return BaseWebResponse.<Void>builder()
                .status(200)
                .message(" Knowledge notes deleted successfully !")
                .build();

    }

    private KnowledgeNotesEntity mapToEntity(KnowledgeNotesReqDto request, Long id){
        KnowledgeNotesEntity knNotes = Objects.nonNull(id)
                ? knowledgeNotesDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Knowledge not found with id: " + id))
                : new KnowledgeNotesEntity();

        knNotes.setUserId(request.getUserId());
        knNotes.setTitle(request.getTitle());
        knNotes.setContent(request.getContent());
        knNotes.setCategoryId(request.getCategoryId());
        knNotes.setTags(request.getTags());
        knNotes.setFavorite(request.getFavorite());

        if(Objects.isNull(id)){
            knNotes.setCreatedAt(LocalDate.now());
        }else {
            knNotes.setUpdatedAt(LocalDate.now());
        }

        return knNotes;
    }
}
