package dev.mivas.ecommerceapi.client.response;

import java.io.Serializable;
import java.math.BigDecimal;

public record PlatziProductResponse(Long id, String title, BigDecimal price) implements Serializable {
}
