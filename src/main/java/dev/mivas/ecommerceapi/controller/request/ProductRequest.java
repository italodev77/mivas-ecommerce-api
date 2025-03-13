package dev.mivas.ecommerceapi.controller.request;

import lombok.Builder;


public record ProductRequest(Long id, Integer quantity) {
}
