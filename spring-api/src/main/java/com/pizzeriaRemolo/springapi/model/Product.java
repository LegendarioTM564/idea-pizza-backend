package com.pizzeriaRemolo.springapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.TrueFalseConverter;

import java.util.List;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;
    private String image;
    //@Convert(converter = TrueFalseConverter.class)
    private boolean is_active;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderList> orderLists;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category category;
}
