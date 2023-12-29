package com.pizzeriaRemolo.springapi.dto;

import com.pizzeriaRemolo.springapi.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private String description;
    private String image;
    private boolean active;
    private Long categoryId;

    public static ProductDTO fromEntity(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setImage(product.getImage());
        productDTO.setDescription(product.getDescription());
        productDTO.setActive(product.isActive());
        productDTO.setCategoryId(product.getCategory() != null ? product.getCategory().getId() : null);
        return productDTO;
    }

    public static List<ProductDTO> convertDtoList(List<Product> listProducts){
        return listProducts.stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
    }

}
