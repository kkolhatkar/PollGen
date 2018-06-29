package com.pollgen.service;

import com.pollgen.entity.Category;

import java.util.List;

public interface CategoryService {

    public void create(Category category);

    public List<Category> read();

}
