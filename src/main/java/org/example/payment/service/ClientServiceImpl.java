package org.example.payment.service;

import org.example.payment.exception.ClientNotFoundException;
import org.example.payment.model.Client;
import org.example.payment.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClient(String CodigoUnico) {
        return clientRepository
                .findById(CodigoUnico)
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
}
