package com.pizzeriaRemolo.springapi.repository;

import com.pizzeriaRemolo.springapi.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderListRepository extends JpaRepository<OrderList,Long> {
}
