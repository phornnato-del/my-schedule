package com.example.myschedule.dao;

import com.example.myschedule.dao.base.BaseDBDao;
import com.example.myschedule.entity.PriorityEntity;
import com.example.myschedule.repository.PriorityRepository;
import org.springframework.stereotype.Component;

@Component
public class PriorityDao extends BaseDBDao<PriorityEntity, Long> {
    private final PriorityRepository repository;
    public PriorityDao(PriorityRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
