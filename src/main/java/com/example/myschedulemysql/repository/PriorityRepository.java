package com.example.myschedulemysql.repository;

import com.example.myschedulemysql.entity.PriorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<PriorityEntity,Long> {
}
