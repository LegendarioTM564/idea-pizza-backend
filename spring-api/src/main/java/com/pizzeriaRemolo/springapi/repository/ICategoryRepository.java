package com.pizzeriaRemolo.springapi.repository;

import com.pizzeriaRemolo.springapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
