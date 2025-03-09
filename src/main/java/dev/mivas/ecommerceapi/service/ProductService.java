package dev.mivas.ecommerceapi.service;

import dev.mivas.ecommerceapi.client.PlatziStoreClient;
import dev.mivas.ecommerceapi.client.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;
    public List<PlatziProductResponse> getAllProducts(){
        return platziStoreClient.getAllProducts();
    }

    public PlatziProductResponse getProductsById(Long id){
        return platziStoreClient.getProductById(id);
    }
}
