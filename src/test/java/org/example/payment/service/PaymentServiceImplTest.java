package org.example.payment.service;

import org.example.payment.dto.PaymentRequestDTO;
import org.example.payment.dto.PaymentResponseDTO;
import org.example.payment.exception.ClientNotFoundException;
import org.example.payment.model.Client;
import org.example.payment.model.PaymentType;
import org.example.payment.repository.ClientRepository;
import org.example.payment.strategy.PaymentStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private PaymentStrategy strategy1;

    @Mock
    private PaymentStrategy strategy2;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    void setup() {

        MockitoAnnotations.openMocks(this);

        paymentService = new PaymentServiceImpl(
                Arrays.asList(strategy1, strategy2),
                clientRepository
        );
    }

    @Test
    void shouldReturnApplicablePaymentMethods() {

        PaymentRequestDTO request = new PaymentRequestDTO();
        request.setCodigoCliente("1000000003");
        request.setDeuda(150.0);

        Client client = new Client();
        client.setCodigoUnico("1000000003");

        when(clientRepository.findById("1000000003"))
                .thenReturn(Optional.of(client));

        when(strategy1.isApplicable(150.0)).thenReturn(true);
        when(strategy1.getPaymentType()).thenReturn(PaymentType.TC_DIRECTO);

        when(strategy2.isApplicable(150.0)).thenReturn(false);

        PaymentResponseDTO response = paymentService.validatePayment(request);

        assertEquals(1, response.getPaymentTypes().size());
        assertEquals(PaymentType.TC_DIRECTO, response.getPaymentTypes().get(0));
    }

    @Test
    void shouldThrowExceptionWhenClientNotFound() {

        PaymentRequestDTO request = new PaymentRequestDTO();
        request.setCodigoCliente("999999");
        request.setDeuda(100.00);

        when(clientRepository.findById("999999"))
                .thenReturn(Optional.empty());

        assertThrows(ClientNotFoundException.class, () -> {
            paymentService.validatePayment(request);
        });
    }
}
