package com.springboot.demo.demo.utils;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {
    public List<T> findAll();
    public T saveOrUpdate(T entity);
    public Optional<T> findById(Long id);
    public void deleteById(Long id);
}
