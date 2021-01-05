package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.bootstrap.BootLoader;
import com.arolla.bankmgm.api.domain.OperationTypeEnum;
import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.model.OperationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services
 */
@SpringBootTest
public class OperationServiceIT {

    private static BigDecimal OPEARATION_AMOUNT = new BigDecimal(150);

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private OperationService operationService;

    @Test
    void testExecuteWithdrawalOperation() {
        BigDecimal bankBalanceStart = bankAccountService.findBalanceByIBAN(BootLoader.IBAN);

        OperationDto operationDto = operationService.executeOperation(createWithdrawalOperation());

        BigDecimal bankBalanceEnd = bankAccountService.findBalanceByIBAN(BootLoader.IBAN);

        assertNotNull(operationDto);

        assertNotEquals(bankBalanceStart, bankBalanceEnd);

        assertEquals(bankBalanceStart.subtract(OPEARATION_AMOUNT), bankBalanceEnd);
    }

    @Test
    void testExecuteDepositOperation() {
        BigDecimal bankBalanceStart = bankAccountService.findBalanceByIBAN(BootLoader.IBAN);

        OperationDto operationDto = operationService.executeOperation(createDepositOperation());

        BigDecimal bankBalanceEnd = bankAccountService.findBalanceByIBAN(BootLoader.IBAN);

        assertNotNull(operationDto);

        assertNotEquals(bankBalanceStart, bankBalanceEnd);

        assertEquals(bankBalanceStart.add(OPEARATION_AMOUNT), bankBalanceEnd);
    }

    private OperationDto createWithdrawalOperation() {
        return createOperation().operationType(OperationTypeEnum.WITHDRAWAL).build();
    }

    private OperationDto createDepositOperation() {
        return createOperation().operationType(OperationTypeEnum.DEPOSIT).build();
    }

    private OperationDto.OperationDtoBuilder createOperation() {
        BankAccountDto bankAccountDto = bankAccountService.findByIBAN(BootLoader.IBAN);

        return OperationDto.builder()
                .amount(OPEARATION_AMOUNT)
                .operationType(OperationTypeEnum.DEPOSIT)
                .createdDate(OffsetDateTime.now())
                .bankAccountDto(bankAccountDto);
    }
}
