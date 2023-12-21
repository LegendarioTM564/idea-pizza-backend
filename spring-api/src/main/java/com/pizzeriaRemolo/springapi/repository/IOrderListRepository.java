package com.pizzeriaRemolo.springapi.repository;

import com.pizzeriaRemolo.springapi.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderListRepository extends JpaRepository<OrderList,Long> {
}
