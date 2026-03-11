package org.example.payment.strategy;

import org.example.payment.model.PaymentType;

public interface PaymentStrategy {
    boolean isApplicable(Double amount );
    PaymentType getPaymentType();
}
