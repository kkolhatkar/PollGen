package com.pollgen.serviceImplementation;

import com.pollgen.entity.Category;
import com.pollgen.repository.CategoryRepository;
import com.pollgen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatgeoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> read() {
        return categoryRepository.findAll();
    }
}
