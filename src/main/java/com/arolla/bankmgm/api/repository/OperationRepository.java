package com.arolla.bankmgm.api.repository;

import com.arolla.bankmgm.api.domain.Client;
import com.arolla.bankmgm.api.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.repository
 */
public interface OperationRepository extends JpaRepository<Operation, UUID> {

    List<Operation> findAllByBankAccountIBAN(String IBAN);
}
