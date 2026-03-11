package org.example.payment.service;

import org.example.payment.dto.Client.ClientRequestDTO;
import org.example.payment.dto.Client.ClientResponseDTO;
import org.example.payment.mapper.ClientMapper;
import org.example.payment.model.Client;
import org.example.payment.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateClient() {

        ClientRequestDTO request = new ClientRequestDTO();
        request.setCodigoCliente("1000000001");
        request.setNombre("Juan");

        Client client = new Client();
        client.setCodigoUnico("1000000001");
        client.setNombres("Juan");

        ClientResponseDTO response = new ClientResponseDTO();
        response.setCodigoCliente("1000000001");
        response.setNombre("Juan");

        when(clientMapper.toEntity(request)).thenReturn(client);
        when(clientRepository.save(client)).thenReturn(client);
        when(clientMapper.toResponse(client)).thenReturn(response);

        ClientResponseDTO result = clientService.createClient(request);

        assertEquals("1000000001", result.getCodigoCliente());
        verify(clientRepository).save(client);
    }
}
