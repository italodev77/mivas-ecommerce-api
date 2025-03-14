package dev.mivas.ecommerceapi.controller;

import dev.mivas.ecommerceapi.controller.request.BasketRequest;
import dev.mivas.ecommerceapi.controller.request.PaymentRequest;
import dev.mivas.ecommerceapi.entity.Basket;
import dev.mivas.ecommerceapi.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")

public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable String id){
        return ResponseEntity.ok(basketService.getBasketById(id));


    }

    @PostMapping
    public ResponseEntity<Basket> createBasket(@RequestBody BasketRequest basketRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(basketService.createBasket(basketRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable String id, @RequestBody BasketRequest basketRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(basketService.updateBasket(id, basketRequest));
    }
    @PutMapping("/{id}/payment")
    public ResponseEntity<Basket> paymentBasket(@PathVariable String id, @RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(basketService.payBasket(id, paymentRequest));
    }


}
