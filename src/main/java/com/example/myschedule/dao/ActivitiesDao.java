package com.example.myschedule.dao;

import com.example.myschedule.dao.base.BaseDBDao;
import com.example.myschedule.entity.ActivitiesEntity;
import com.example.myschedule.repository.ActivitiesRepository;
import org.springframework.stereotype.Component;

@Component
public class ActivitiesDao extends BaseDBDao<ActivitiesEntity, Long> {

    private final ActivitiesRepository repository;

    public ActivitiesDao(ActivitiesRepository repository) {
        super(repository);
        this.repository = repository;
    }


}