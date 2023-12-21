package com.pizzeriaRemolo.springapi.repository;

import com.pizzeriaRemolo.springapi.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
