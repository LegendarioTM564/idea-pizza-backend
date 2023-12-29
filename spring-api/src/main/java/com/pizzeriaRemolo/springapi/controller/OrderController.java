package com.pizzeriaRemolo.springapi.controller;

import com.pizzeriaRemolo.springapi.dto.OrderConfirmationDTO;
import com.pizzeriaRemolo.springapi.dto.OrderDTO;
import com.pizzeriaRemolo.springapi.dto.ProductDTO;
import com.pizzeriaRemolo.springapi.model.Order;
import com.pizzeriaRemolo.springapi.model.OrderDetail;
import com.pizzeriaRemolo.springapi.model.OrderList;
import com.pizzeriaRemolo.springapi.model.Product;
import com.pizzeriaRemolo.springapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;





    /*@GetMapping(value= "/listOrders")
    public ResponseEntity<List<OrderDTO>> ListProducts(){
        List<Order> listOrder = orderService.getListOrder();
        List<OrderDTO> listOrderDTO = ProductDTO.convertDtoList(listproducts);
        return ResponseEntity.ok(listProductsDTO);
    }*/

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> getProduct(@PathVariable Long id){
        Order order = orderService.findOrder(id);
        if(order != null){
            OrderDTO orderDTO = OrderDTO.fromEntity(order);
            return ResponseEntity.ok(orderDTO);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(value = "/confirm")
    public ResponseEntity<String> saveOrder(@RequestBody OrderConfirmationDTO orderConfirmationDTO){

        OrderDetail confirmOrderDetail = orderConfirmationDTO.getOrderDetail();
        List<OrderList> confirmOrderList = orderConfirmationDTO.getOrderLists();

        Order order = new Order();
        order.calculateTotal(confirmOrderList);
        order.setOrderDetail(confirmOrderDetail);
        order.setCreate_at(LocalDateTime.now());

        orderService.saveOrderConfirmation(order, confirmOrderDetail,confirmOrderList);

        return ResponseEntity.ok("Orden Guardada");
    }

}
