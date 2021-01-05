package com.arolla.bankmgm.api.bootstrap;

import com.arolla.bankmgm.api.domain.BankAccount;
import com.arolla.bankmgm.api.domain.Client;
import com.arolla.bankmgm.api.repository.BankAccountRepository;
import com.arolla.bankmgm.api.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 04/01/2021, in com.arolla.bankmgm.service.bootstrap
 */
@RequiredArgsConstructor
@Component
public class BootLoadder implements CommandLineRunner {

    public static final UUID CLIENT_1_UUID = UUID.randomUUID();

    public static final String IBAN = "NL51ABNA4892894109";

    private final ClientRepository clientRepository;
    private final BankAccountRepository bankAccountRepository;

    @Override
    public void run(String... args) throws Exception {
        Client client = clientRepository.save(
                Client.builder()
                        .id(CLIENT_1_UUID)
                        .name("Amine")
                        .lastName("BECHRAOUI")
                        .build()
        );

        bankAccountRepository.save(
                BankAccount.builder()
                .client(client)
                .balance(new BigDecimal(10000))
                .IBAN(IBAN)
                .build()
        );
    }
}
