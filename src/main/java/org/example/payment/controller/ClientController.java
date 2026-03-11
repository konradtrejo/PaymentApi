package org.example.payment.controller;


import org.example.payment.dto.Client.ClientRequestDTO;
import org.example.payment.dto.Client.ClientResponseDTO;
import org.example.payment.model.Client;
import org.example.payment.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }

    @GetMapping("/{codigoCliente}")
    public ClientResponseDTO getClient(@PathVariable String codigoCliente) {
        return clientService.getClient(codigoCliente);
    }

    @PostMapping
    public ClientResponseDTO createClient(@RequestBody ClientRequestDTO client) {
        return clientService.createClient(client);
    }

}
