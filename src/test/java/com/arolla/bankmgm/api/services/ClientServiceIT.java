package com.arolla.bankmgm.api.services;

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

        assertEquals(2, clientDtos.size());
    }

    private ClientDto createClientDto() {
        return ClientDto.builder()
                .name("Amine")
                .lastName("BECHRAOUI")
                .build();
    }
}
