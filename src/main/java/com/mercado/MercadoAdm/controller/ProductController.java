package com.mercado.MercadoAdm.controller;

import com.mercado.MercadoAdm.model.Product;
import com.mercado.MercadoAdm.repository.ProductRepository;
import com.mercado.MercadoAdm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductRepository productRepository;
    private ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> registerProduct(@RequestBody Product product) {
        try {
            Product productSave = this.productService.register(product);

            return ResponseEntity.status(201).body(productSave);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getOne(@PathVariable(value = "id") int idProduct) {
        try {
            Product product = productService.getOne(idProduct);

            return ResponseEntity.status(200).body(product);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAllProducts() {
        try {
            List<Product> productList = this.productService.getAll();

            return ResponseEntity.status(200).body(productList);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("product/{id}")
    public ResponseEntity<Optional<Product>> updateProduct(@PathVariable(name = "id", required = true) int idProduct, @RequestBody Product product) {
        try {
            this.productService.update(idProduct, product);

            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(name = "id", required = true) int id) {
        try {
            this.productService.delete(id);

            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
