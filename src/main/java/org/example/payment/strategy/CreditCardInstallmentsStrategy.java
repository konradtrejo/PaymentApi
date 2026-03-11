package org.example.payment.strategy;

import org.example.payment.model.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class CreditCardInstallmentsStrategy  implements PaymentStrategy {
    @Override
    public boolean isApplicable(Double amount) {
        return amount >=300;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.TC_COUTAS;
    }
}
