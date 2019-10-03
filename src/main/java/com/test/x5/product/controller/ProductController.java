package com.test.x5.product.controller;

import com.test.x5.product.model.Product;
import com.test.x5.product.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin
public class ProductController {

    private final ProductsRepository repository;

    @Autowired
    public ProductController(ProductsRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> getProductById(@RequestParam(name = "id") Long id) {

        return ResponseEntity.ok(repository.findById(id).orElse(null));
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> createProduct(RequestEntity<Product> productRequest) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(Objects.requireNonNull(productRequest.getBody(), "Request body cannot be null.")));
    }
}
