package com.example.BankApplication.service;

import com.example.BankApplication.model.Client;
import com.example.BankApplication.model.dto.ClientMapper;
import com.example.BankApplication.model.dto.ClientRequest;
import com.example.BankApplication.model.dto.ClientResponse;
import com.example.BankApplication.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Client save(ClientRequest clientRequest){
        Client client = clientMapper.map(clientRequest);
        return clientRepository.save(client);
    }
    public ClientResponse findByEmail(String email){
        Client client = clientRepository.findByEmail(email);
        return clientMapper.map(client);
    }
}
