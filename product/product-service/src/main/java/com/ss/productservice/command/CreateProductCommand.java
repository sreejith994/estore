package com.ss.productservice.command;

import lombok.Builder;

import java.math.BigDecimal;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
public record CreateProductCommand(
        @TargetAggregateIdentifier String productId,
        String title,
        BigDecimal price,
        Integer quantity
) {


}
