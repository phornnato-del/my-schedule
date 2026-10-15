package com.example.myschedule.repository;

import com.example.myschedule.entity.ProjectTasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTasksRepository extends JpaRepository<ProjectTasksEntity,Long> {
    void deleteById(Long id);
}
