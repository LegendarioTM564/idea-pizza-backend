package com.pizzeriaRemolo.springapi.service;

import com.pizzeriaRemolo.springapi.model.Product;
import com.pizzeriaRemolo.springapi.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getListProduct() {
        List<Product> listProducts = iProductRepository.findAll();
        return listProducts;
    }

    @Override
    public Product findProduct(Long id) {
        Product product = iProductRepository.findById(id).orElse(null);
        return product;
    }

    @Override
    public void saveProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void saveListProduct(List<Product> listProducts) {
        iProductRepository.saveAll(listProducts);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> optionalProduct = iProductRepository.findById(id);
        if(optionalProduct.isPresent()){
            iProductRepository.deleteById(id);
        }else {
            throw new NoSuchElementException("Producto con ID " + id + " no encontrado");
        }
    }

    @Override
    public void editProduct(Product product) {
        this.saveProduct(product);
    }
}
