package com.pizzeriaRemolo.springapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private double total;
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime create_at;

    @OneToOne
    @JoinColumn(name = "order_details_id", nullable = false)
    private OrderDetail orderDetail;

    public void calculateTotal(List<OrderList> orderLists){
        if(orderLists != null){
            double total = orderLists.stream()
                    .peek(orderList -> {
                        System.out.println("Product Price: " + orderList.getProduct().getPrice());
                        System.out.println("Quantity: " + orderList.getQuantity());
                    })
                    .mapToDouble(orderList -> orderList.getProduct().getPrice() * orderList.getQuantity())
                    .sum();
            System.out.println("Calculated Total: " + total);
            setTotal(total);
        }else {
            setTotal(0.0);
        }
    }

}
