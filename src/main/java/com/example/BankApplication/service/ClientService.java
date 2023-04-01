package com.example.BankApplication.service;

import com.example.BankApplication.model.Client;
import com.example.BankApplication.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Client findByEmail(String email){
        return clientRepository.findByEmail(email);
    }
}
