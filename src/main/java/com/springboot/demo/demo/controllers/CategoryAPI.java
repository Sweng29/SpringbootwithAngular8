package com.springboot.demo.demo.controllers;

import com.springboot.demo.demo.models.Category;
import com.springboot.demo.demo.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/categories/")
public class CategoryAPI {

    private CategoryService categoryService;

    public CategoryAPI(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll()
    {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id)
    {
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent())
        {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(category.get());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Category category)
    {
        System.out.println(category);
        return ResponseEntity.ok(categoryService.saveOrUpdate(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id,@Valid @RequestBody Category category)
    {
        Optional<Category> categoryFound = categoryService.findById(id);
        if(!categoryFound.isPresent())
        {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(categoryService.saveOrUpdate(category));
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Long id)
    {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if(!categoryOptional.isPresent())
        {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
