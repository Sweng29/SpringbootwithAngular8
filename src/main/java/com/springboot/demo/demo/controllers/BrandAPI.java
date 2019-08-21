package com.springboot.demo.demo.controllers;

import com.springboot.demo.demo.models.Brand;
import com.springboot.demo.demo.models.Product;
import com.springboot.demo.demo.services.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/brands/")
public class BrandAPI {

    private BrandService brandService;

    public BrandAPI(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<Brand>> findAll()
    {
        return ResponseEntity.ok(brandService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Brand brand)
    {
        return ResponseEntity.ok(brandService.saveOrUpdate(brand));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Brand> findById(@PathVariable Long id){
        Optional<Brand> brand = brandService.findById(id);
        if(!brand.isPresent())
        {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(brand.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(@PathVariable Long id,@Valid @RequestBody Brand brand)
    {
        Optional<Brand> brandFound = brandService.findById(id);
        if(!brandFound.isPresent())
        {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(brandService.saveOrUpdate(brand));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Brand> deleteById(@PathVariable Long id)
    {
        Optional<Brand> brandFound = brandService.findById(id);
        if(!brandFound.isPresent())
        {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        brandService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
