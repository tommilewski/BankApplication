package com.example.BankApplication.model.dto.client;

import com.example.BankApplication.model.Account;
import com.example.BankApplication.model.Client;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClientMapper {
    public ClientResponse map(Client client){
        return ClientResponse
                .builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .accounts(client
                        .getAccounts()
                        .stream()
                        .map(Account::getId)
                        .collect(Collectors.toList()))
                .build();
    }

    public Client map(ClientRequest clientRequest) {
        return Client.builder()
                .email(clientRequest.getEmail())
                .name(clientRequest.getName())
                .build();
    }


}
