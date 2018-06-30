package com.pollgen.service;

import com.pollgen.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

	public void create(CategoryEntity category);

	public List<CategoryEntity> read();

}
