package com.ss.productservice.core.events;


import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductCreatedEvent(
        String productId,
        String title,
        BigDecimal price,
        Integer quantity
) {
}
