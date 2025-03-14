package dev.mivas.ecommerceapi.controller.request;

import dev.mivas.ecommerceapi.entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    private PaymentMethod paymentMethod;
}
