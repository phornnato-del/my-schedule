package com.example.myschedule.dao;

import com.example.myschedule.dao.base.BaseDBDao;
import com.example.myschedule.entity.GoalTasksEntity;
import com.example.myschedule.entity.KnowledgeNotesEntity;
import com.example.myschedule.repository.GoalTasksepository;
import com.example.myschedule.repository.KnowledgeNotesRepository;
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