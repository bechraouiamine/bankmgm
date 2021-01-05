package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.domain.Client;
import com.arolla.bankmgm.api.model.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services
 */
@Service
public interface ClientService {
    ClientDto createClient(ClientDto clientDto);

    List<ClientDto> listClient();

    ClientDto findById(UUID id);

    ClientDto findByNameAndLastName(String name, String lastName);

}
