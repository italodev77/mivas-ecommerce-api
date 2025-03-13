package dev.mivas.ecommerceapi.service;

import dev.mivas.ecommerceapi.client.response.PlatziProductResponse;
import dev.mivas.ecommerceapi.controller.request.BasketRequest;
import dev.mivas.ecommerceapi.entity.Basket;
import dev.mivas.ecommerceapi.entity.Product;
import dev.mivas.ecommerceapi.entity.Status;
import dev.mivas.ecommerceapi.repository.BasketRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@AllArgsConstructor

public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;


    public Basket getBasketById(String id){
        return basketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cesta de compras não encontrada."));
    }

    public Basket createBasket(BasketRequest basketRequest){

        basketRepository.findByClientAndStatus( basketRequest.clientId(), Status.OPEN)
                .ifPresent(basket -> {
                    throw  new IllegalArgumentException("Já existe uma cesta de compras aberta para esse cliente");
                });

        List<Product> products = new ArrayList<>();
        basketRequest.products().forEach( productRequest -> {
            PlatziProductResponse platziProductResponse = productService.getProductsById(productRequest.id());
            Product.builder()
                    .id(platziProductResponse.id())
                    .title(platziProductResponse.title())
                    .price(platziProductResponse.price())
                    .quantity(productRequest.quantity())
                    .build();
        });

        Basket basket = Basket.builder()
                .client(basketRequest.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);

    }
}
