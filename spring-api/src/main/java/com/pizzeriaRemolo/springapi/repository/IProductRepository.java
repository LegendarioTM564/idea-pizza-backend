package com.pizzeriaRemolo.springapi.repository;

import com.pizzeriaRemolo.springapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}
