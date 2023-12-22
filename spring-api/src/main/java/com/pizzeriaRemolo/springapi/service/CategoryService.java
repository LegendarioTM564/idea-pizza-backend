package com.pizzeriaRemolo.springapi.service;

import com.pizzeriaRemolo.springapi.model.Category;
import com.pizzeriaRemolo.springapi.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{

    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getListCategory() {
        List<Category> listCategory = iCategoryRepository.findAll();
        return listCategory;
    }

    @Override
    public Category findCartegory(Long id) {
        Category category = iCategoryRepository.findById(id).orElse(null);
        return category;
    }

    @Override
    public void saveCategory(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void saveListCategory(List<Category> listCategory) {
        iCategoryRepository.saveAll(listCategory);
    }

    @Override
    public void editCategory(Category category) {
        this.saveCategory(category);
    }

    @Override
    public void deleteCategory(Long id) {
        iCategoryRepository.deleteById(id);
    }
}
