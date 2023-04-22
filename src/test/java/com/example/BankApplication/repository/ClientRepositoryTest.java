package com.example.BankApplication.repository;

import com.example.BankApplication.model.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    public void itShouldCheckIfClientEmailExists(){
        //given
        String email = "tommil@gmail.com";
        Client client = new Client(1L, "Tomasz", email, List.of());
        underTest.save(client);

        //when
        Client result = underTest.findByEmail(email);

        //then
        Assertions.assertEquals(client, result);

    }
}
