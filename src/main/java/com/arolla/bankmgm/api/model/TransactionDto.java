package com.arolla.bankmgm.api.model;

import com.arolla.bankmgm.api.domain.TransactionTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private UUID id;

    private BigDecimal amount;

    private TransactionTypeEnum transactionType;

    private BankAccountDto bankAccountDto;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    @JsonProperty("createdDate")
    private OffsetDateTime createdDate = null;

}
