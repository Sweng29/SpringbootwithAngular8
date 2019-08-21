package com.springboot.demo.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/")
    public String list(){
        return "products";
    }
}
