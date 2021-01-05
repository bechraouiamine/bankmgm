package com.arolla.bankmgm.api.services.impl;

import com.arolla.bankmgm.api.domain.BankAccount;
import com.arolla.bankmgm.api.domain.OperationTypeEnum;
import com.arolla.bankmgm.api.mapper.BankAccountMapper;
import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.repository.BankAccountRepository;
import com.arolla.bankmgm.api.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services.impl
 */
@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountDto findByIBAN(String IBAN) {
        return null;
    }

    @Override
    public BigDecimal findBalanceByIBAN(String IBAN) {
        return null;
    }

    @Override
    public BankAccountDto updateBankAccountBalance(BigDecimal amount, OperationTypeEnum operationType, String BankAccountIBAN) {
        return null;
    }
}