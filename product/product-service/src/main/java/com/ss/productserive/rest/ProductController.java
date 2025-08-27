package com.ss.productserive.rest;

import com.ss.productserive.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final CommandGateway commandGateway;

    @PostMapping()
    public String createProduct(@RequestBody CreateProductRequest request) {
        CreateProductCommand command = CreateProductCommand
                .builder()
                .price(request.price())
                .quantity(request.quantity())
                .title(request.title())
                .productId(UUID.randomUUID().toString())
                .build();
        String returnValue;
        try {
            returnValue = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            returnValue = e.getLocalizedMessage();
        }
        return returnValue;
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

