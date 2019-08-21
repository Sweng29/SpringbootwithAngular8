package com.springboot.demo.demo.services;

import com.springboot.demo.demo.models.Category;
import com.springboot.demo.demo.repositories.CategoryRepository;
import com.springboot.demo.demo.utils.GenericDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService implements GenericDAO<Category> {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveOrUpdate(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
