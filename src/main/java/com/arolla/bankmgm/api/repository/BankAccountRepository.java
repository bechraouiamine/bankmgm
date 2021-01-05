package com.arolla.bankmgm.api.repository;

import com.arolla.bankmgm.api.domain.BankAccount;
import com.arolla.bankmgm.api.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.repository
 */
public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {
    BankAccount findByIBAN(String iban);

    BigDecimal findAmountByIBAN(String iban);
}
