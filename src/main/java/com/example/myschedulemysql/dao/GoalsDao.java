package com.example.myschedulemysql.dao;

import com.example.myschedulemysql.dao.base.BaseDBDao;
import com.example.myschedulemysql.entity.GoalsEntity;
import com.example.myschedulemysql.repository.GoalsRepository;
import org.springframework.stereotype.Component;

@Component
public class GoalsDao extends BaseDBDao<GoalsEntity, Long> {

    private final GoalsRepository goalsRepository;

    public GoalsDao(GoalsRepository goalsRepository) {
        super(goalsRepository);
        this.goalsRepository = goalsRepository;
    }

    public void deleteById(Long id) {
        goalsRepository.deleteById(id);
    }

}