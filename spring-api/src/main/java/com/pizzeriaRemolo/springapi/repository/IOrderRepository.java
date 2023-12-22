package com.pizzeriaRemolo.springapi.repository;

import com.pizzeriaRemolo.springapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {
}
