package org.example.payment.controller;

import org.example.payment.dto.PaymentRequestDTO;
import org.example.payment.dto.PaymentResponseDTO;
import org.example.payment.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/validate")
    public PaymentResponseDTO validatePayment(@RequestBody PaymentRequestDTO request) {
        return paymentService.validatePayment(request);
    }
}