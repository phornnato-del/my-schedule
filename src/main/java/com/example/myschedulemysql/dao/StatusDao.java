package com.example.myschedulemysql.dao;

import com.example.myschedulemysql.dao.base.BaseDBDao;
import com.example.myschedulemysql.entity.StatusEntity;
import com.example.myschedulemysql.repository.StatusRepository;
import org.springframework.stereotype.Component;

@Component
public class StatusDao extends BaseDBDao<StatusEntity, Long> {
    private final StatusRepository repository;
    public StatusDao(StatusRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
