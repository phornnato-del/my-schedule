package com.example.myschedulemysql.dao;

import com.example.myschedulemysql.dao.base.BaseDBDao;
import com.example.myschedulemysql.entity.PriorityEntity;
import com.example.myschedulemysql.repository.PriorityRepository;
import org.springframework.stereotype.Component;

@Component
public class PriorityDao extends BaseDBDao<PriorityEntity, Long> {
    private final PriorityRepository repository;
    public PriorityDao(PriorityRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
