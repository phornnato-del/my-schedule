package com.example.myschedulemysql.service;

import com.example.myschedulemysql.dto.request.KnowledgeNotesReqDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.KnowledgeNotesResDto;

import java.io.IOException;
import java.util.List;

public interface knowledgeNoteService {
    BaseWebResponse<KnowledgeNotesResDto> insert(KnowledgeNotesReqDto request) throws IOException;
    BaseWebResponse<List<KnowledgeNotesResDto>> getAll() throws IOException;
    BaseWebResponse<KnowledgeNotesResDto> getById(Long id) throws IOException;
    BaseWebResponse<KnowledgeNotesResDto> update(Long id, KnowledgeNotesReqDto request) throws IOException;
    BaseWebResponse<Void> delete(Long id) throws IOException;
}
