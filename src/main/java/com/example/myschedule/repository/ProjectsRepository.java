package com.example.myschedule.repository;

import com.example.myschedule.entity.GoalsEntity;
import com.example.myschedule.entity.ProjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<ProjectsEntity,Long> {
    void deleteById(Long id);
}
