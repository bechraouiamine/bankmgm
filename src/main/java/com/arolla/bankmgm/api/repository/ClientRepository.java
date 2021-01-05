package com.arolla.bankmgm.api.repository;

import com.arolla.bankmgm.api.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by aminebechraoui, on 04/01/2021, in com.arolla.bankmgm.service.repository
 */
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Client findByNameAndLastName(String name, String lastName);
}
