package com.example.myschedule.dao;

import com.example.myschedule.dao.base.BaseDBDao;
import com.example.myschedule.entity.GoalsEntity;
import com.example.myschedule.repository.GoalsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

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