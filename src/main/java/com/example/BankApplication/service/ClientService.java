package com.example.BankApplication.service;

import com.example.BankApplication.model.Client;
import com.example.BankApplication.model.dto.client.ClientMapper;
import com.example.BankApplication.model.dto.client.ClientRequest;
import com.example.BankApplication.model.dto.client.ClientResponse;
import com.example.BankApplication.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Client save(ClientRequest clientRequest){
        if (clientRepository.findByEmail(clientRequest.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email exists");
        }
        Client client = clientMapper.map(clientRequest);
        return clientRepository.save(client);
    }
    public ClientResponse findByEmail(String email){
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Email does not exist"));
        return clientMapper.map(client);
    }
}
