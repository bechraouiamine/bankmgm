package com.arolla.bankmgm.api.services.impl;

import com.arolla.bankmgm.api.domain.BankAccount;
import com.arolla.bankmgm.api.domain.OperationTypeEnum;
import com.arolla.bankmgm.api.mapper.BankAccountMapper;
import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.repository.BankAccountRepository;
import com.arolla.bankmgm.api.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services.impl
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    public static final String END_UPDATE_BANK_ACCOUNT = "End updateBankAccountBalance : ";
    public static final String BEGIN_UPDATE_BANK_ACCOUNT = "Begin updateBankAccountBalance : ";
    public static final String OPERATION_TYPE = " OperationType : ";
    public static final String AMOUNT = " Amount : ";
    public static final String IBAN = " IBAN : ";
    public static final String BANK_BALANCE = " Bank Balance : ";
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountDto findByIBAN(String IBAN) {
        return bankAccountMapper.bankAccountToBankAccountDto(bankAccountRepository.findByIBAN(IBAN));
    }

    @Override
    public BigDecimal findBalanceByIBAN(String IBAN) {
        return bankAccountRepository.findByIBAN(IBAN).getBalance();
    }

    @Override
    public BankAccountDto updateBankAccountBalance(BigDecimal amount, OperationTypeEnum operationType, String BankAccountIBAN) {
        BankAccount bankAccount = bankAccountRepository.findByIBAN(BankAccountIBAN);
        log.info(BEGIN_UPDATE_BANK_ACCOUNT + AMOUNT + amount + OPERATION_TYPE + operationType + IBAN + BankAccountIBAN + BANK_BALANCE + bankAccount.getBalance());
        if (operationType.equals(OperationTypeEnum.WITHDRAWAL)) {
            amount = amount.negate();
        }
        bankAccount.setBalance(bankAccount.getBalance().add(amount));
        BankAccountDto updatedBankAccount = bankAccountMapper.bankAccountToBankAccountDto(bankAccountRepository.save(bankAccount));
        log.info(BEGIN_UPDATE_BANK_ACCOUNT + AMOUNT + amount + OPERATION_TYPE + operationType + IBAN + updatedBankAccount.getIBAN() + BANK_BALANCE + updatedBankAccount.getBalance());
        return updatedBankAccount;
    }
}
