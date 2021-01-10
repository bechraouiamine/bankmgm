package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.bootstrap.BootLoader;
import com.arolla.bankmgm.api.domain.TransactionTypeEnum;
import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.model.TransactionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services
 */
@SpringBootTest
@Transactional
public class TransactionServiceIT {

    private static BigDecimal TRANSACTION_AMOUNT = new BigDecimal(150);

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private TransactionService transactionService;

    @Test
    void testExecuteWithdrawalTransaction() {
        BigDecimal bankBalanceStart = bankAccountService.findBalanceByIBAN(BootLoader.IBAN_TEST);

        TransactionDto transactionDto = transactionService.executeTransaction(createWithdrawalTransaction());

        BigDecimal bankBalanceEnd = bankAccountService.findBalanceByIBAN(BootLoader.IBAN_TEST);

        assertNotNull(transactionDto);

        assertNotEquals(bankBalanceStart, bankBalanceEnd);

        assertEquals(bankBalanceStart.subtract(TRANSACTION_AMOUNT), bankBalanceEnd);
    }

    @Test
    void testExecuteDepositTransaction() {
        BigDecimal bankBalanceStart = bankAccountService.findBalanceByIBAN(BootLoader.IBAN_TEST);

        TransactionDto transactionDto = transactionService.executeTransaction(createDepositTransaction());

        BigDecimal bankBalanceEnd = bankAccountService.findBalanceByIBAN(BootLoader.IBAN_TEST);

        assertNotNull(transactionDto);

        assertNotEquals(bankBalanceStart, bankBalanceEnd);

        assertEquals(bankBalanceStart.add(TRANSACTION_AMOUNT), bankBalanceEnd);
    }

    @Test
    void testFindAllByIban() {
        TransactionDto transactionDto = createWithdrawalTransaction();

        TransactionDto executedTransactionDto = transactionService.executeTransaction(transactionDto);

        List<TransactionDto> transactionDtos = transactionService.findAllTransactionsByIBAN(BootLoader.IBAN_TEST);

        assertNotNull(transactionDtos);

        assertEquals(1, transactionDtos.size());
    }

    private TransactionDto createWithdrawalTransaction() {
        return createTransaction().transactionType(TransactionTypeEnum.WITHDRAWAL).build();
    }

    private TransactionDto createDepositTransaction() {
        return createTransaction().transactionType(TransactionTypeEnum.DEPOSIT).build();
    }

    private TransactionDto.TransactionDtoBuilder createTransaction() {
        BankAccountDto bankAccountDto = bankAccountService.findByIBAN(BootLoader.IBAN_TEST);

        return TransactionDto.builder()
                .amount(TRANSACTION_AMOUNT)
                .transactionType(TransactionTypeEnum.DEPOSIT)
                .createdDate(OffsetDateTime.now())
                .bankAccountDto(bankAccountDto);
    }
}
