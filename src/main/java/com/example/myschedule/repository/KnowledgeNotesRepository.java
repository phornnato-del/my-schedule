package com.example.myschedule.repository;

import com.example.myschedule.entity.KnowledgeNotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeNotesRepository extends JpaRepository<KnowledgeNotesEntity,Long> {
    void deleteById(Long id);
}
