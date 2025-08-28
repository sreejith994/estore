package com.ss.productservice.rest;

import java.math.BigDecimal;

public record CreateProductRequest(
        String title,
        BigDecimal price,
        Integer quantity
) {
}
