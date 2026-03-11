package org.example.payment.service;

import org.example.payment.dto.Client.ClientRequestDTO;
import org.example.payment.dto.Client.ClientResponseDTO;
import org.example.payment.model.Client;

public interface ClientService {

    ClientResponseDTO getClient(String CodigoUnico);
    ClientResponseDTO createClient(ClientRequestDTO client);

}
