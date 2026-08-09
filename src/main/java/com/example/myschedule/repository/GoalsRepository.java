package com.example.myschedule.repository;

import com.example.myschedule.entity.GoalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoalsRepository extends JpaRepository<GoalsEntity,Long> {
    void deleteById(Long id);
}
