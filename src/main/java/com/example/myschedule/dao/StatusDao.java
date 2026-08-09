package com.example.myschedule.dao;

import com.example.myschedule.dao.base.BaseDBDao;
import com.example.myschedule.entity.StatusEntity;
import com.example.myschedule.repository.StatusRepository;
import org.springframework.stereotype.Component;

@Component
public class StatusDao extends BaseDBDao<StatusEntity, Long> {
    private final StatusRepository repository;
    public StatusDao(StatusRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
