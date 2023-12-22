package com.pizzeriaRemolo.springapi.service;

import com.pizzeriaRemolo.springapi.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {

    //Metodo para traer todos las categorias.
    public List<Category> getListCategory();

    //Metodo para traer una sola categoria.
    public Category findCartegory(Long id);

    //Metodo para guardar categoria.
    public void saveCategory(Category category);

    //Metodo para guardar lista de categorias.
    public void saveListCategory (List<Category> listCategory);

    //Metodo para editar una categoria.
    public void editCategory(Category category);

    //Metodo para eliminar una categoria.
    public void deleteCategory(Long id);

}
