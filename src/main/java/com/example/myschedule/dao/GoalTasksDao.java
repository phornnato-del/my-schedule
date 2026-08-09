package com.example.myschedule.dao;

import com.example.myschedule.dao.base.BaseDBDao;
import com.example.myschedule.entity.GoalTasksEntity;
import com.example.myschedule.repository.GoalTasksepository;
import org.springframework.stereotype.Component;

@Component
public class GoalTasksDao extends BaseDBDao<GoalTasksEntity, Long> {

    private final GoalTasksepository goaltasksRepository;

    public GoalTasksDao(GoalTasksepository goaltasksRepository) {
        super(goaltasksRepository);
        this.goaltasksRepository = goaltasksRepository;
    }

    public void deleteById(Long id) {
        goaltasksRepository.deleteById(id);
    }

}