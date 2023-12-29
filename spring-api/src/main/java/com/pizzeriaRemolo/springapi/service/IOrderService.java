package com.pizzeriaRemolo.springapi.service;


import com.pizzeriaRemolo.springapi.model.Order;
import com.pizzeriaRemolo.springapi.model.OrderDetail;
import com.pizzeriaRemolo.springapi.model.OrderList;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrderService {

    //Metodo para traer todas las ordenes.
    public List<Order> getListOrder();

    //Metodo para traer una sola orden.
    public Order findOrder(Long id);

    //Metodo para guardar una orden.
    public void saveOrder(Order order);

    //Metodo para guardar lista de ordenes.
    public void saveListOrder (List<Order> listOrder);

    //Metodo para editar una orden.
    public void editOrder(Order order);

    //Metodo para eliminar una orden.
    public void deleteOrder(Long id);

    public Order saveOrderConfirmation(Order order, OrderDetail orderDetail, List<OrderList> orderLists);

}
