package com.example.myschedule.repository;

import com.example.myschedule.entity.PriorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<PriorityEntity,Long> {
}
