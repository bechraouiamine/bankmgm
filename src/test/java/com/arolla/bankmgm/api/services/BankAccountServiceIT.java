package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.bootstrap.BootLoader;
import com.arolla.bankmgm.api.domain.OperationTypeEnum;
import com.arolla.bankmgm.api.model.BankAccountDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services
 */
@SpringBootTest
public class BankAccountServiceIT {

    @Autowired
    BankAccountService bankAccountService;

    @Test
    void testUpdateBankAccountBalance() {
        BankAccountDto bankAccountDto = bankAccountService.findByIBAN(BootLoader.IBAN);

        assertNotNull(bankAccountDto);

        BankAccountDto bankAccountDtoUpdated = bankAccountService.updateBankAccountBalance(new BigDecimal(123), OperationTypeEnum.WITHDRAWAL, BootLoader.IBAN);

        assertEquals(bankAccountDto.getBalance().subtract(new BigDecimal(123)), bankAccountDtoUpdated.getBalance());
    }
}
