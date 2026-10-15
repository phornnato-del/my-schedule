package com.example.myschedule.dao;

import com.example.myschedule.dao.base.BaseDBDao;
import com.example.myschedule.entity.ProjectTasksEntity;
import com.example.myschedule.repository.ProjectTasksRepository;
import org.springframework.stereotype.Component;

@Component
public class ProjectTasksDao extends BaseDBDao<ProjectTasksEntity, Long> {

    private final ProjectTasksRepository repository;

    public ProjectTasksDao(ProjectTasksRepository repository) {
        super(repository);
        this.repository = repository;
    }


}