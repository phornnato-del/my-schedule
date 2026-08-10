package com.example.myschedulemysql.repository;

import com.example.myschedulemysql.entity.GoalTasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalTasksepository extends JpaRepository<GoalTasksEntity,Long> {
    void deleteById(Long id);
}
