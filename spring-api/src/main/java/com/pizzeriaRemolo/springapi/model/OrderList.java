package com.pizzeriaRemolo.springapi.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products_in_order")
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @NotNull(message = "cantidad del producto requerido.")
    private int quantity;
    //private double total;

    @ManyToOne
    @JoinColumn(name="product_id")
    @Valid
    @NotNull(message = "id del producto requerido.")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetail orderDetail;


}
