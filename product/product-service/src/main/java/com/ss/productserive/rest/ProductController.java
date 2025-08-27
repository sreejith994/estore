package com.ss.productserive.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping()
    public String createProduct(@RequestBody CreateProductRequest request) {
        
        return "Product created: "+ request.title();
    }

    @GetMapping()
    public String getProducts() {
        return "Product list";
    }

    @PutMapping()
    public String updateProduct() {
        return "Product updated";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Product deleted";
    }
}

