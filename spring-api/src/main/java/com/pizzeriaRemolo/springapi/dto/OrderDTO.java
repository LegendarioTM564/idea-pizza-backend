package com.pizzeriaRemolo.springapi.dto;

import com.pizzeriaRemolo.springapi.model.Order;
import com.pizzeriaRemolo.springapi.model.OrderList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String customer_name;
    private String delivery_address;
    private String phone_number;
    private double total;
    private int quantity;
    private List<ProductInfoDTO> productInfoList;


    public static OrderDTO fromEntity(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCustomer_name(order.getOrderDetail().getCustomer_name());
        orderDTO.setDelivery_address(order.getOrderDetail().getDelivery_address());
        orderDTO.setPhone_number(order.getOrderDetail().getPhone_number());
        orderDTO.setTotal(order.getTotal());

        List<ProductInfoDTO> productInfoList = new ArrayList<>();

        if (order.getOrderDetail().getOrderLists() != null) {

            for (OrderList orderList : order.getOrderDetail().getOrderLists()){
                ProductInfoDTO productInfoDTO = new ProductInfoDTO();
                productInfoDTO.setName_product(orderList.getProduct().getName());
                productInfoDTO.setQuantity(orderList.getQuantity());
                productInfoList.add(productInfoDTO);
            }

        }
        orderDTO.setProductInfoList(productInfoList);
        return orderDTO;
    }

}
