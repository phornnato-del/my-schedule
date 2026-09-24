package com.example.myschedule.dao;

import com.example.myschedule.dao.base.BaseDBDao;
import com.example.myschedule.entity.ProjectsEntity;
import com.example.myschedule.repository.ProjectsRepository;
import org.springframework.stereotype.Component;

@Component
public class ProjectDao extends BaseDBDao<ProjectsEntity, Long> {

    private final ProjectsRepository repository;

    public ProjectDao(ProjectsRepository repository) {
        super(repository);
        this.repository = repository;
    }


}