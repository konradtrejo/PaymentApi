package org.example.payment.strategy;

import org.example.payment.model.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class CreditCardDirectStrategy implements PaymentStrategy {
    @Override
    public boolean isApplicable(Double amount) {
        return amount > 100;
    }

    @Override
    public PaymentType getPaymentType() {
        return  PaymentType.TC_DIRECTO;
    }
}
