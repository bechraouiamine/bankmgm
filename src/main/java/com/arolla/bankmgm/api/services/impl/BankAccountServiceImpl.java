package com.arolla.bankmgm.api.services.impl;

import com.arolla.bankmgm.api.domain.BankAccount;
import com.arolla.bankmgm.api.domain.TransactionTypeEnum;
import com.arolla.bankmgm.api.mapper.BankAccountMapper;
import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.printers.impl.BankAccountPrinter;
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
    public static final String Transaction_TYPE = " transaction type : ";
    public static final String AMOUNT = " Amount : ";
    public static final String IBAN = " IBAN : ";
    public static final String BANK_BALANCE = " Bank Balance : ";

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;
    private final BankAccountPrinter bankAccountPrinter;

    @Override
    public BankAccountDto findByIBAN(String IBAN) {
        return bankAccountMapper.bankAccountToBankAccountDto(bankAccountRepository.findByIBAN(IBAN));
    }

    @Override
    public BigDecimal findBalanceByIBAN(String IBAN) {
        return bankAccountRepository.findByIBAN(IBAN).getBalance();
    }

    @Override
    public BankAccountDto updateBankAccountBalance(BigDecimal amount, TransactionTypeEnum transactionType, String BankAccountIBAN) {
        BankAccountDto bankAccountDto = findByIBAN(BankAccountIBAN);

        bankAccountPrinter.print(bankAccountDto);

        if (transactionType.equals(TransactionTypeEnum.WITHDRAWAL)) {
            amount = amount.negate();
        }

        bankAccountDto.setBalance(bankAccountDto.getBalance().add(amount));

        BankAccountDto updatedBankAccount = bankAccountMapper.bankAccountToBankAccountDto(
                bankAccountRepository.save(
                        bankAccountMapper.bankAccountDtoToBankAccount(bankAccountDto)
                )
        );

        bankAccountPrinter.print(updatedBankAccount);

        return updatedBankAccount;
    }
}
