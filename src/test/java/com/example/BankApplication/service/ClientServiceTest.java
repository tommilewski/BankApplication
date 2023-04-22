package com.example.BankApplication.service;

import com.example.BankApplication.model.Client;
import com.example.BankApplication.model.dto.client.ClientMapper;
import com.example.BankApplication.model.dto.client.ClientRequest;
import com.example.BankApplication.model.dto.client.ClientResponse;
import com.example.BankApplication.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService underTest;

    @Test
    public void itShouldCheckIfClientEmailExists(){
        //given
        String email = "tommil@gmail.com";
        Client client = new Client(1L, "Tomasz", email, List.of());

        //when
        when(clientRepository.findByEmail(email)).thenReturn(Optional.of(client));
        when(clientMapper.map(client)).thenReturn(new ClientResponse(1L, "Tomasz", email, List.of()));

        //then
        String result = underTest.findByEmail(email).getEmail();
        Assertions.assertEquals(client.getEmail(), result);
    }

    @Test
    public void itShouldCheckIfClientEmailDoesNotExist(){
        //given
        String email = "tommil@gmail.com";

        //when
        when(clientRepository.findByEmail(email)).thenThrow(new IllegalArgumentException());

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.findByEmail(email));
    }

    @Test
    public void itShouldThrowExceptionWhenSaveClientWithUsedEmail(){
        //given
        String email = "tommil@gmail.com";
        ClientRequest client = new ClientRequest("Tomasz", email);

        //when
        when(clientRepository.findByEmail(email)).thenReturn(Optional.of(new Client(1L, "Tomasz", email, List.of())));

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.save(client));
    }

    @Test
    @Disabled
    public void itShouldSaveClientCorrectly(){
        //given
        String email = "tommil@gmail.com";
        ClientRequest client = new ClientRequest("Tomasz", email);

        //when
        when(clientMapper.map(client)).thenReturn(new Client(1L, "Tomasz", email, List.of()));

        //then
       Client result = underTest.save(client);

       Assertions.assertEquals(client.getName(), result.getName());
       Assertions.assertEquals(client.getEmail(), result.getEmail());
    }


}