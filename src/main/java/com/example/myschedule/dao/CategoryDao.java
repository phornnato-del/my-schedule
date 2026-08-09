package com.example.myschedule.dao;

import com.example.myschedule.dao.base.BaseDBDao;
import com.example.myschedule.entity.CategoryEntity;
import com.example.myschedule.repository.CategoryRepository;
import com.example.myschedule.repository.PriorityRepository;
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