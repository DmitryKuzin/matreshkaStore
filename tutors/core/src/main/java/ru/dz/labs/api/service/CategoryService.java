package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.domain.Category;
import ru.dz.labs.api.repository.CategoryRepository;

import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(Category category){
        categoryRepository.addCategory(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.getAllCategories();
    }

    public void updateCategory(Category category) {
        categoryRepository.updateCategory(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    public void deleteCategory(Category category) {
        categoryRepository.deleteCategory(category);
    }

}
