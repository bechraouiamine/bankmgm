package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.domain.TransactionTypeEnum;
import com.arolla.bankmgm.api.model.BankAccountDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services
 */
@Service
public interface BankAccountService {

    BankAccountDto findByIBAN(String IBAN);

    BigDecimal findBalanceByIBAN(String IBAN);

    BankAccountDto updateBankAccountBalance(BigDecimal amount, TransactionTypeEnum transactionType, String BankAccountIBAN);
}
