package org.example.payment.mapper;

import org.example.payment.dto.Client.ClientRequestDTO;
import org.example.payment.dto.Client.ClientResponseDTO;
import org.example.payment.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequestDTO dto) {

        Client client = new Client();
        client.setCodigoUnico(dto.getCodigoCliente());
        client.setNombres(dto.getNombre());
        client.setApellidos(dto.getApellidos());
        client.setTipoDocumento(dto.getTipoDocumento());
        client.setNumeroDocumento(dto.getNumeroDocumento());
        return client;
    }

    public ClientResponseDTO toResponse(Client client) {

        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setCodigoCliente(client.getCodigoUnico());
        dto.setNombre(client.getNombres());
        dto.setApellidos(client.getApellidos());
        dto.setTipoDocumento(client.getTipoDocumento());
        dto.setNumeroDocumento(client.getNumeroDocumento());
        return dto;
    }
}