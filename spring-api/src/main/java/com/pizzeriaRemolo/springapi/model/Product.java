package com.pizzeriaRemolo.springapi.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.type.TrueFalseConverter;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "nombre del producto requerido.")
    @Valid
    private String name;
    @Valid
    @NotNull(message = "precio del producto requerido.")
    private double price;
    @Valid
    @NotNull(message = "descripcion del producto requerido.")
    private String description;
    @Valid
    @NotNull(message = "image del producto requerido.")
    private String image;
    @Valid
    @NotNull(message = "estado del producto requerido.")
    @Column(name = "is_active")
    //@Convert(converter = org.hibernate.type.YesNoConverter.class)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    @Valid
    @NotNull(message = "categoria del producto requerido.")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderList> orderLists;


}
