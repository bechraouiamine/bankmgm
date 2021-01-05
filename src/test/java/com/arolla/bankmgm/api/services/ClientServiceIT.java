package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.bootstrap.BootLoader;
import com.arolla.bankmgm.api.model.ClientDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.*;



/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services
 */
@SpringBootTest
public class ClientServiceIT {

    private static final String NAME = "Client";

    private static final String LAST_NAME = "Le Riche";

    @Autowired
    ClientService clientService;

    @Test
    void testNewClient() {
        ClientDto createdClientDto = clientService.createClient(createClientDto());

        assertNotNull(createdClientDto);
    }

    @Test
    void testFindAll() {
        ClientDto createdClientDto = clientService.createClient(createClientDto());

        List<ClientDto> clientDtos = clientService.listClient();

        assertNotNull(clientDtos);

        // We are expecting 2 clients as we already created a client in BooLoader.java
        assertEquals(2, clientDtos.size());
    }

    @Test
    void testFindByNameAndLastName() {
        ClientDto clientDto = clientService.findByNameAndLastName(BootLoader.NAME, BootLoader.LAST_NAME);

        assertNotNull(clientDto);
    }

    private ClientDto createClientDto() {
        return ClientDto.builder()
                .name(NAME)
                .lastName(LAST_NAME)
                .build();
    }
}
