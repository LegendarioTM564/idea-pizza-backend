package com.pizzeriaRemolo.springapi.service;
import com.pizzeriaRemolo.springapi.model.OrderList;
import com.pizzeriaRemolo.springapi.repository.IOrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderListService implements IOrderListService{

    @Autowired
    IOrderListRepository iOrderListRepository;

    @Override
    public List<OrderList> getListOrderList() {
        List<OrderList> listOrderList = iOrderListRepository.findAll();
        return listOrderList;
    }

    @Override
    public OrderList findOrderList(Long id) {
        OrderList orderList = iOrderListRepository.findById(id).orElse(null);
        return orderList;
    }

    @Override
    public void saveOrderList(OrderList orderlist) {
        iOrderListRepository.save(orderlist);
    }

    @Override
    public void saveListOrderList(List<OrderList> listOrderList) {
        iOrderListRepository.saveAll(listOrderList);
    }

    @Override
    public void editOrderList(OrderList orderList) {
        this.saveOrderList(orderList);
    }

    @Override
    public void deleteOrderList(Long id) {
        iOrderListRepository.deleteById(id);
    }
}
