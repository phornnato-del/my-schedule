package com.example.myschedule.repository;

import com.example.myschedule.entity.GoalTasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalTasksepository extends JpaRepository<GoalTasksEntity,Long> {
    void deleteById(Long id);
}
