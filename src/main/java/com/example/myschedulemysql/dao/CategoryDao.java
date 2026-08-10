package com.example.myschedulemysql.dao;

import com.example.myschedulemysql.dao.base.BaseDBDao;
import com.example.myschedulemysql.entity.CategoryEntity;
import com.example.myschedulemysql.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDao extends BaseDBDao<CategoryEntity, Long> {
    private final CategoryRepository repository;
    public CategoryDao(CategoryRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<CategoryEntity> findByType(String type) {
        return  repository.findByType(type);
    }
}