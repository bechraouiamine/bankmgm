package com.arolla.bankmgm.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountDto {
    private UUID id;

    private BigDecimal balance;

    private ClientDto clientDto;

    private String IBAN;

    private List<TransactionDto> transactionDtos;
}
