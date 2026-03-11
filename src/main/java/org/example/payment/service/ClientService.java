package org.example.payment.service;

import org.example.payment.model.Client;

public interface ClientService {

    Client getClient(String CodigoUnico);
    Client createClient(Client client);
}
