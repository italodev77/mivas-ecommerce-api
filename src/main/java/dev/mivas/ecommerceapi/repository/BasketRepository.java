package dev.mivas.ecommerceapi.repository;

import dev.mivas.ecommerceapi.entity.Basket;
import dev.mivas.ecommerceapi.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket, String> {

    Optional<Basket> findByClientAndStatus(Long client, Status status);
}
