package org.example.payment.service;

import org.example.payment.dto.PaymentRequestDTO;
import org.example.payment.dto.PaymentResponseDTO;
import org.example.payment.exception.ClientNotFoundException;
import org.example.payment.model.Client;
import org.example.payment.model.PaymentType;
import org.example.payment.repository.ClientRepository;
import org.example.payment.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PaymentServiceImpl  implements PaymentService {

    private final List<PaymentStrategy> paymentStrategies;
    private final ClientRepository clientRepository;

    public PaymentServiceImpl(List<PaymentStrategy> paymentStrategies, ClientRepository clientRepository) {
        this.paymentStrategies = paymentStrategies;
        this.clientRepository = clientRepository;
    }


    @Override
    public PaymentResponseDTO validatePayment(PaymentRequestDTO paymentRequestDTO) {
        Client client = clientRepository.findById(paymentRequestDTO.getCodigoCliente())
                .orElseThrow(ClientNotFoundException::new);

        List<PaymentType> payments = paymentStrategies.stream()
                .filter(s -> s.isApplicable(paymentRequestDTO.getDeuda()))
                .map(PaymentStrategy::getPaymentType)
                .collect(Collectors.toList());

        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setPaymentTypes(payments);

        return response;
    }
}
