package com.pizzeriaRemolo.springapi.service;

import com.pizzeriaRemolo.springapi.model.Order;
import com.pizzeriaRemolo.springapi.model.OrderDetail;
import com.pizzeriaRemolo.springapi.model.OrderList;
import com.pizzeriaRemolo.springapi.repository.IOrderDetailRepository;
import com.pizzeriaRemolo.springapi.repository.IOrderListRepository;
import com.pizzeriaRemolo.springapi.repository.IOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements IOrderService{

    @Autowired
    IOrderRepository iOrderRepository;

    @Autowired
    IOrderDetailRepository iOrderDetailRepository;

    @Autowired
    IOrderListRepository iOrderListRepository;

    @Override
    public List<Order> getListOrder() {
        List<Order> listOrder = iOrderRepository.findAll();
        return listOrder;
    }

    @Override
    public Order findOrder(Long id) {
        Order order = iOrderRepository.findById(id).orElse(null);
        return order;
    }

    @Override
    public void saveOrder(Order order) {
        iOrderRepository.save(order);
    }

    @Override
    public void saveListOrder(List<Order> listOrder) {
        iOrderRepository.saveAll(listOrder);
    }

    @Override
    public void editOrder(Order order) {
        this.saveOrder(order);
    }

    @Override
    public void deleteOrder(Long id) {
        iOrderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Order saveOrderConfirmation(Order order, OrderDetail orderDetail, List<OrderList> orderLists) {

        OrderDetail savedOrderDetail = iOrderDetailRepository.save(orderDetail);

        for (OrderList orderList : orderLists){
            orderList.setOrderDetail(savedOrderDetail);
            //iOrderListRepository.save(orderList);
        }
        iOrderListRepository.saveAll(orderLists);

        order.setOrderDetail(savedOrderDetail);
        Order ordersave = iOrderRepository.save(order);
        return ordersave ;

    }

}
