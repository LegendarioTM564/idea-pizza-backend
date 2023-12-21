package com.pizzeriaRemolo.springapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customer_name;
    private String delivery_address;
    private String phone_number;

    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
    private List<OrderList> orderLists;

}
