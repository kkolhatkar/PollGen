package com.pollgen.controller;

import com.pollgen.entity.Category;
import com.pollgen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void create(@RequestBody Category category) {
        categoryService.create(category);
    }

    @GetMapping
    @ResponseBody
    public List<Category> read() {
        return categoryService.read();
	}
	
}
