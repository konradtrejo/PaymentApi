package org.example.payment.service;

import org.example.payment.dto.Client.ClientRequestDTO;
import org.example.payment.dto.Client.ClientResponseDTO;
import org.example.payment.exception.ClientNotFoundException;
import org.example.payment.mapper.ClientMapper;
import org.example.payment.model.Client;
import org.example.payment.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientResponseDTO getClient(String CodigoUnico) {
        Client client =     clientRepository
                            .findById(CodigoUnico)
                            .orElseThrow(ClientNotFoundException::new);
        return clientMapper.toResponse(client);
    }

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO client) {
        Client newClient = clientMapper.toEntity(client);
        Client saved = clientRepository.save(newClient);
        return  clientMapper.toResponse(saved);
    }
}
