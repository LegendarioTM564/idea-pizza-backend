package com.pizzeriaRemolo.springapi.service;
import com.pizzeriaRemolo.springapi.model.OrderDetail;
import com.pizzeriaRemolo.springapi.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    IOrderDetailRepository iOrderDetailRepository;

    @Override
    public List<OrderDetail> getListOrderDetail() {

        List<OrderDetail> listOrderDetail = iOrderDetailRepository.findAll();
        return listOrderDetail;
    }

    @Override
    public OrderDetail findOrderDetail(Long id) {
        OrderDetail orderDetail = iOrderDetailRepository.findById(id).orElse(null);
        return orderDetail;
    }

    @Override
    public void saveOrderDetail(OrderDetail orderDetail) {
        iOrderDetailRepository.save(orderDetail);
    }

    @Override
    public void saveListOrderDetail(List<OrderDetail> listOrderDetail) {
        iOrderDetailRepository.saveAll(listOrderDetail);
    }

    @Override
    public void editOrderDetail(OrderDetail orderDetail) {
        this.saveOrderDetail(orderDetail);
    }

    @Override
    public void deleteOrderDetail(Long id) {
        iOrderDetailRepository.deleteById(id);
    }
}
