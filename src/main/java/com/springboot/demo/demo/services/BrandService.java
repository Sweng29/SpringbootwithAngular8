package com.springboot.demo.demo.services;

import com.springboot.demo.demo.models.Brand;
import com.springboot.demo.demo.repositories.BrandRepository;
import com.springboot.demo.demo.utils.GenericDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BrandService implements GenericDAO<Brand> {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand saveOrUpdate(Brand entity) {
        return brandRepository.save(entity);
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}
