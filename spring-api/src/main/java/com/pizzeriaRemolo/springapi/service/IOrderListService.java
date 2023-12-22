package com.pizzeriaRemolo.springapi.service;

import com.pizzeriaRemolo.springapi.model.OrderList;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrderListService {

    //Metodo para traer todas las lista de ordenes.
    public List<OrderList> getListOrderList();

    //Metodo para traer una sola lista de ordenes.
    public  OrderList findOrderList(Long id);

    //Metodo para guardar una lista de ordenes.
    public void saveOrderList(OrderList orderlist);

    //Metodo para guardar lista de lista de ordenes.
    public void saveListOrderList(List<OrderList> listOrderList);

    //Metodo para editar una lista de ordenes.
    public void editOrderList(OrderList orderList);

    //Metodo para eliminar una lista de ordenes.
    public void deleteOrderList(Long id);

}
