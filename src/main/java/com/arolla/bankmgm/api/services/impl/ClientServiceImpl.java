package com.arolla.bankmgm.api.services.impl;

import com.arolla.bankmgm.api.domain.Client;
import com.arolla.bankmgm.api.mapper.ClientMapper;
import com.arolla.bankmgm.api.model.ClientDto;
import com.arolla.bankmgm.api.repository.ClientRepository;
import com.arolla.bankmgm.api.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services.impl
 */
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        return null;
    }

    @Override
    public List<ClientDto> listClient() {
        return null;
    }

    @Override
    public ClientDto findById(UUID id) {
        return null;
    }

    @Override
    public ClientDto findByNameAndLastName(String name, String lastName) {
        return null;
    }
}
