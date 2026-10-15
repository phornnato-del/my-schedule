package com.example.myschedule.repository;

import com.example.myschedule.entity.ActivitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends JpaRepository<ActivitiesEntity,Long> {
    void deleteById(Long id);
}
