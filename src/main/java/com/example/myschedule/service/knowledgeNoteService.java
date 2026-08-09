package com.example.myschedule.service;

import com.example.myschedule.dto.request.GoalTasksReqDto;
import com.example.myschedule.dto.request.KnowledgeNotesReqDto;
import com.example.myschedule.dto.response.BaseWebResponse;
import com.example.myschedule.dto.response.GoalTasksResDto;
import com.example.myschedule.dto.response.KnowledgeNotesResDto;

import java.io.IOException;
import java.util.List;

public interface knowledgeNoteService {
    BaseWebResponse<KnowledgeNotesResDto> insert(KnowledgeNotesReqDto request) throws IOException;
    BaseWebResponse<List<KnowledgeNotesResDto>> getAll() throws IOException;
    BaseWebResponse<KnowledgeNotesResDto> getById(Long id) throws IOException;
    BaseWebResponse<KnowledgeNotesResDto> update(Long id, KnowledgeNotesReqDto request) throws IOException;
    BaseWebResponse<Void> delete(Long id) throws IOException;
}
