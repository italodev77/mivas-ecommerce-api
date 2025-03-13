package dev.mivas.ecommerceapi.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Product {
    private Long id;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
