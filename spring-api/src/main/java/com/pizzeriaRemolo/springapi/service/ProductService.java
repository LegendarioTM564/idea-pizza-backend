package com.pizzeriaRemolo.springapi.service;

import com.pizzeriaRemolo.springapi.model.Product;
import com.pizzeriaRemolo.springapi.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Product saveProduct(Product product) {
        iProductRepository.save(product);

        return product;
    }

    @Override
    public void saveListProduct(List<Product> listProducts) {
        iProductRepository.saveAll(listProducts);
    }

    @Override
    public void deleteProduct(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public void editProduct(Product product) {
        this.saveProduct(product);
    }
}
