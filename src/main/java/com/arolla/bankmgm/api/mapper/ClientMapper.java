package com.arolla.bankmgm.api.mapper;

import com.arolla.bankmgm.api.domain.Client;
import com.arolla.bankmgm.api.model.ClientDto;
import org.mapstruct.Mapper;

/**
 * Created by aminebechraoui, on 04/01/2021, in com.arolla.bankmgm.service
 */
@Mapper
public interface ClientMapper {
    ClientDto clientToClientDto(Client client);

    Client clientDtoToClient(ClientDto client);
}
