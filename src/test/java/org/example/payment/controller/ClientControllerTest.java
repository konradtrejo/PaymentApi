package org.example.payment.controller;

import org.example.payment.dto.Client.ClientResponseDTO;
import org.example.payment.security.JwtUtil;
import org.example.payment.service.ClientService;
import org.example.payment.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(ClientController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private ClientService clientService;

    @Test
    void shouldReturnClient() throws Exception {

        ClientResponseDTO response = new ClientResponseDTO();
        response.setCodigoCliente("1000000001");
        response.setNombre("Juan");

        Mockito.when(clientService.getClient("1000000001"))
                .thenReturn(response);

        mockMvc.perform(get("/api/clients/1000000001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigoCliente").value("1000000001"))
                .andExpect(jsonPath("$.nombre").value("Juan"));
    }
}
