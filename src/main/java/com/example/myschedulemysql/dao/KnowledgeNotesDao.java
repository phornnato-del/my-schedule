package com.example.myschedulemysql.dao;

import com.example.myschedulemysql.dao.base.BaseDBDao;
import com.example.myschedulemysql.entity.KnowledgeNotesEntity;
import com.example.myschedulemysql.repository.KnowledgeNotesRepository;
import org.springframework.stereotype.Component;

@Component
public class KnowledgeNotesDao extends BaseDBDao<KnowledgeNotesEntity, Long> {

    private final KnowledgeNotesRepository knowledgeNotesRepository;

    public KnowledgeNotesDao(KnowledgeNotesRepository knowledgeNotesRepository) {
        super(knowledgeNotesRepository);
        this.knowledgeNotesRepository = knowledgeNotesRepository;
    }
    public void deleteById(Long id) {
        knowledgeNotesRepository.deleteById(id);
    }

}