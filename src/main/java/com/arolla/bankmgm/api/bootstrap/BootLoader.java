package com.arolla.bankmgm.api.bootstrap;

import com.arolla.bankmgm.api.domain.BankAccount;
import com.arolla.bankmgm.api.domain.Client;
import com.arolla.bankmgm.api.domain.Transaction;
import com.arolla.bankmgm.api.domain.TransactionTypeEnum;
import com.arolla.bankmgm.api.repository.BankAccountRepository;
import com.arolla.bankmgm.api.repository.ClientRepository;
import com.arolla.bankmgm.api.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 04/01/2021, in com.arolla.bankmgm.service.bootstrap
 */
@RequiredArgsConstructor
@Component
public class BootLoader implements CommandLineRunner {

    public static final UUID CLIENT_1_UUID = UUID.randomUUID();
    public static final String IBAN = "NL51ABNA4892894109";
    public static final String IBAN_TEST = "GB86BARC20031869685989";
    public static final String NAME = "Amine";
    public static final String LAST_NAME = "BECHRAOUI";

    public static final BigDecimal BALANCE = new BigDecimal(1000);
    public static final BigDecimal AMOUNT = new BigDecimal(150);

    private final ClientRepository clientRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {
        Client client = clientRepository.save(
                Client.builder()
                        .name(NAME)
                        .lastName(LAST_NAME)
                        .build()
        );

        BankAccount bankAccount
         = bankAccountRepository.save(
                BankAccount.builder()
                .client(client)
                .balance(BALANCE)
                .IBAN(IBAN)
                .build()
        );

        BankAccount bankAccountTest
                = bankAccountRepository.save(
                BankAccount.builder()
                        .client(client)
                        .balance(BALANCE)
                        .IBAN(IBAN_TEST)
                        .build()
        );

        Transaction transaction = transactionRepository.save(
                Transaction.builder()
                .amount(AMOUNT)
                .bankAccount(bankAccount)
                .transactionType(TransactionTypeEnum.WITHDRAWAL)
                .createdDate(Timestamp.from(Instant.now()))
                .build()
        );
    }
}
