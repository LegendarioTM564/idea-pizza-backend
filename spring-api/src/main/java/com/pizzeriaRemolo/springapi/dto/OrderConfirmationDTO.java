package com.pizzeriaRemolo.springapi.dto;

import com.pizzeriaRemolo.springapi.model.OrderDetail;
import com.pizzeriaRemolo.springapi.model.OrderList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderConfirmationDTO {

    private OrderDetail orderDetail;
    private List<OrderList> orderLists;

}
