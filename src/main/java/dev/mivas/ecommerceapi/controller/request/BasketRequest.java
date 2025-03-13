package dev.mivas.ecommerceapi.controller.request;

import dev.mivas.ecommerceapi.entity.Product;

import java.util.List;

public record BasketRequest(Long clientId, List<ProductRequest> products) {

}
