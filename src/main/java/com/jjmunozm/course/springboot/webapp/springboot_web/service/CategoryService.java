package com.jjmunozm.course.springboot.webapp.springboot_web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jjmunozm.course.springboot.webapp.springboot_web.model.Category;
import com.jjmunozm.course.springboot.webapp.springboot_web.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }

    public Category newCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategory(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category updateCategory(int id, Category category) {
        Optional<Category> categoryExist = categoryRepository.findById(id);
        if (categoryExist.isPresent()) {
            category.setId(id);
            return categoryRepository.save(category);
        }
        return null;
    }

    public boolean deleteCategory(int id) {
        Optional<Category> categoryExist = categoryRepository.findById(id);
        if (categoryExist.isPresent()) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
