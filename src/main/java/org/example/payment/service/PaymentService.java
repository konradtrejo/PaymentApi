package org.example.payment.service;

import org.example.payment.dto.PaymentRequestDTO;
import org.example.payment.dto.PaymentResponseDTO;

public interface PaymentService {
    PaymentResponseDTO validatePayment(PaymentRequestDTO paymentRequestDTO);
}
