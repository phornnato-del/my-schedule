package com.example.myschedulemysql.repository;

import com.example.myschedulemysql.entity.GoalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalsRepository extends JpaRepository<GoalsEntity,Long> {
    void deleteById(Long id);
}
