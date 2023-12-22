package com.pizzeriaRemolo.springapi.repository;

import com.pizzeriaRemolo.springapi.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
