package com.example.myschedulemysql.dao;

import com.example.myschedulemysql.dao.base.BaseDBDao;
import com.example.myschedulemysql.entity.GoalTasksEntity;
import com.example.myschedulemysql.repository.GoalTasksepository;
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