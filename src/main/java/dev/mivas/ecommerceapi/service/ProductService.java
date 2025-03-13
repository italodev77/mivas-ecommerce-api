package dev.mivas.ecommerceapi.service;

import dev.mivas.ecommerceapi.client.PlatziStoreClient;
import dev.mivas.ecommerceapi.client.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductResponse> getAllProducts(){
        log.info("Geting all products");
        return platziStoreClient.getAllProducts();
    }

    @Cacheable(value = "product", key = "#productId")
    public PlatziProductResponse getProductsById(Long productId){
        log.info("Getting product with id: {}", productId);
        return platziStoreClient.getProductById(productId);
    }
}
