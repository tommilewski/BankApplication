package com.example.BankApplication.controller;

import com.example.BankApplication.model.dto.client.ClientResponse;
import com.example.BankApplication.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/api/client/{email}")
    public ResponseEntity<ClientResponse> findByEmail(@PathVariable String email){
        ClientResponse clientResponse = clientService.findByEmail(email);
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }
}
