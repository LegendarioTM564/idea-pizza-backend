package com.pizzeriaRemolo.springapi.repository;

import com.pizzeriaRemolo.springapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
