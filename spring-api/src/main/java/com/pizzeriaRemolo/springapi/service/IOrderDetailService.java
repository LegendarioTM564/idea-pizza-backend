package com.pizzeriaRemolo.springapi.service;
import com.pizzeriaRemolo.springapi.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrderDetailService {

    //Metodo para traer todos los detalles de ordenes.
    public List<OrderDetail> getListOrderDetail();

    //Metodo para traer un solo detalle de orden.
    public OrderDetail findOrderDetail(Long id);

    //Metodo para guardar una detalle de orden.
    public void saveOrderDetail(OrderDetail orderDetail);

    //Metodo para guardar lista de detalles de ordenes.
    public void saveListOrderDetail(List<OrderDetail> listOrderDetail);

    //Metodo para editar una detalle de orden.
    public void editOrderDetail(OrderDetail orderDetail);

    //Metodo para eliminar una detalle de orden.
    public void deleteOrderDetail(Long id);

}
