package com.example.myschedulemysql.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseDBDao<T, ID> {

    private final JpaRepository<T, ID> repository;

    protected BaseDBDao(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T saveEntity(T entity) {
        return repository.save(entity);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public void deleteEntity(T entity) {
        repository.delete(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    public long count() {
        return repository.count();
    }

    public void saveAll(List<T> entities) {
        repository.saveAll(entities);
    }
}