package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.bootstrap.BootLoader;
import com.arolla.bankmgm.api.domain.TransactionTypeEnum;
import com.arolla.bankmgm.api.model.TransactionDto;
import lombok.RequiredArgsConstructor;
import lombok.With;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WorkHardPlayHard {

    private final DepositService depositService;

    private final WithdrawalService withdrawalService;

    private final BankAccountService bankAccountService;

    private static final BigDecimal highBalance = new BigDecimal(900);
    private static final BigDecimal lowBalance = new BigDecimal(500);

    @Transactional
    @Scheduled(fixedRate = 2000) //run every 2 seconds
    public void placeTastingRoomOrder() {

        BigDecimal balance = bankAccountService.findBalanceByIBAN(BootLoader.IBAN);

        log.info("Balance is : " + balance);

        if (balance.compareTo(highBalance) < 0) {
            log.info("Work Hard");
            depositService.depositTransaction(
                    TransactionDto.builder()
                            .transactionType(TransactionTypeEnum.DEPOSIT)
                            .bankAccountDto(bankAccountService.findByIBAN(BootLoader.IBAN))
                            .amount(new BigDecimal(200))
                            .createdDate(OffsetDateTime.now())
                            .build()

            );
        }
        else if (balance.compareTo(lowBalance) > 0) {
            log.info("Play Hard");
            withdrawalService.withdrawalTransaction(
                    TransactionDto.builder()
                            .transactionType(TransactionTypeEnum.WITHDRAWAL)
                            .bankAccountDto(bankAccountService.findByIBAN(BootLoader.IBAN))
                            .amount(new BigDecimal(600))
                            .createdDate(OffsetDateTime.now())
                            .build()

            );
        }

    }
}
