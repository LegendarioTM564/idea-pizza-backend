package com.pizzeriaRemolo.springapi.controller;

import com.pizzeriaRemolo.springapi.dto.ProductDTO;
import com.pizzeriaRemolo.springapi.model.Product;
import com.pizzeriaRemolo.springapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

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
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product){
        iProductService.saveProduct(product);
        return new ResponseEntity<>("Producto Guardado", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        try {
            iProductService.deleteProduct(id);
            return ResponseEntity.ok("Producto eliminado");
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

}
