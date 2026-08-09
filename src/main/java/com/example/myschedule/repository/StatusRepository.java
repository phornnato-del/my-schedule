package com.example.myschedule.repository;

import com.example.myschedule.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<StatusEntity,Long> {
}
