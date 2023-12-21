package com.pizzeriaRemolo.springapi.repository;

import com.pizzeriaRemolo.springapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Long> {
}
