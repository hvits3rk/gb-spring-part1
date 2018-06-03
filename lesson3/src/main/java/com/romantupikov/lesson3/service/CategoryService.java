package com.romantupikov.lesson3.service;

import com.romantupikov.lesson3.entity.Category;
import com.romantupikov.lesson3.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category findById(String categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    public Category findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public void add(Category category) {
        repository.save(category);
    }

    public void update(Category category) {
        Optional<Category> optionalCategory = repository.findById(category.getId());
        if (optionalCategory.isPresent()) {
            repository.save(category);
        }
    }

    public void delete(Category category) {
        repository.delete(category);
    }
}
