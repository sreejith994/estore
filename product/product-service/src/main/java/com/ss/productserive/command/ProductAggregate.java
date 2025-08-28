package com.ss.productserive.command;

import com.ss.productserive.core.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private BigDecimal price;
    private String title;
    private int quantity;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        if(command.price().compareTo(BigDecimal.ZERO) <=0)
            throw new IllegalArgumentException("Price must be greater than zero");
        if(command.title() == null || command.title().isEmpty())
            throw new IllegalArgumentException("Title cannot be empty");
        ProductCreatedEvent productCreatedEvent = ProductCreatedEvent.builder()
                .productId(command.productId())
                .title(command.title())
                .quantity(command.quantity())
                .price(command.price())
                .build();
        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.productId = event.productId();
        this.price = event.price();
        this.title = event.title();
        this.quantity = event.quantity();

    }


}
