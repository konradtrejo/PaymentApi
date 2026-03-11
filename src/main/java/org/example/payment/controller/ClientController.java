package org.example.payment.controller;


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
    public Client getClient(@PathVariable String codigoCliente) {
        return clientService.getClient(codigoCliente);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

}
