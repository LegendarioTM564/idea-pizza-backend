package com.pizzeriaRemolo.springapi.service;

import com.pizzeriaRemolo.springapi.model.Product;

import java.util.List;

public interface IProductService {

    //Metodo para traer todos los productos disponibles.
    public List<Product> getListProduct();

    //Metodo para traer un solo producto.
    public Product findProduct(Long id);

    //Metodo para guardar productos.
    public void saveProduct(Product product);

    //Metodo para guardar lista de productos.
    public  void saveListProduct(List<Product>listProducts);

    //Metodo para eliminar un producto.
    public  void deleteProduct(Long id);

    //Metodo para editar un producto.
    public  void editProduct(Product product);

}
