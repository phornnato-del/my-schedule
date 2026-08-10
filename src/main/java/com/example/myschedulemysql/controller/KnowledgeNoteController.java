package com.example.myschedulemysql.controller;

import com.example.myschedulemysql.dto.request.KnowledgeNotesReqDto;
import com.example.myschedulemysql.dto.response.BaseWebResponse;
import com.example.myschedulemysql.dto.response.KnowledgeNotesResDto;
import com.example.myschedulemysql.service.knowledgeNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/knowledge-note")
@RequiredArgsConstructor
public class KnowledgeNoteController {

    private final knowledgeNoteService knowledgeNoteService;

    @GetMapping
    public BaseWebResponse<List<KnowledgeNotesResDto>> getAll() throws IOException {
        return knowledgeNoteService.getAll();
    }

    @GetMapping("/{id}")
    public BaseWebResponse<KnowledgeNotesResDto> getAllGoalTaskById(@PathVariable Long id) throws IOException{
        return knowledgeNoteService.getById(id);
    }

    @PostMapping
    public BaseWebResponse<KnowledgeNotesResDto> insert(@RequestBody KnowledgeNotesReqDto request) throws IOException{
        return knowledgeNoteService.insert(request);
    }

    @PostMapping("/update/{id}")
    public BaseWebResponse<KnowledgeNotesResDto> update(@PathVariable  Long id, @RequestBody KnowledgeNotesReqDto request) throws IOException {
        return knowledgeNoteService.update(id, request);
    }

    @PostMapping("/delete/{id}")
    public BaseWebResponse<Void> delete(@PathVariable Long id) throws IOException {
        return knowledgeNoteService.delete(id);
    }
}
