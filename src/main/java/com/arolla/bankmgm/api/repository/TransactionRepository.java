package com.arolla.bankmgm.api.repository;

import com.arolla.bankmgm.api.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.repository
 */
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findAllByBankAccountIBAN(String IBAN);
}
