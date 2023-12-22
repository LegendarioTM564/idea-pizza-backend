package com.pizzeriaRemolo.springapi.controller;

import com.pizzeriaRemolo.springapi.dto.ProductDTO;
import com.pizzeriaRemolo.springapi.model.Product;
import com.pizzeriaRemolo.springapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    public IProductService iProductService;

    @GetMapping(value= "/list")
    public ResponseEntity<List<ProductDTO>> ListProducts(){
        List<Product> listproducts = iProductService.getListProduct();
        List<ProductDTO> listProductsDTO = ProductDTO.convertDtoList(listproducts);
        return ResponseEntity.ok(listProductsDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
        Product product = iProductService.findProduct(id);
        if(product != null){
            ProductDTO productDTO = ProductDTO.fromEntity(product);
            return ResponseEntity.ok(productDTO);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product saveProduct = iProductService.saveProduct(product);
        return ResponseEntity.ok(saveProduct);
    }
}
