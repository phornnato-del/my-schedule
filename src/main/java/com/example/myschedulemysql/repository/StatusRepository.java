package com.example.myschedulemysql.repository;

import com.example.myschedulemysql.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<StatusEntity,Long> {
}
