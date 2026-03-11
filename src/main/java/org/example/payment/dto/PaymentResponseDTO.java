package org.example.payment.dto;

import org.example.payment.model.PaymentType;

import java.util.List;

public class PaymentResponseDTO {
    private List<PaymentType> paymentTypes;

    public List<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(List<PaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }
}
