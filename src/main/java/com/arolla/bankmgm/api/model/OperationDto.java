package com.arolla.bankmgm.api.model;

import com.arolla.bankmgm.api.domain.BankAccount;
import com.arolla.bankmgm.api.domain.OperationTypeEnum;
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
public class OperationDto {
    private UUID id;

    private BigDecimal amount;

    private OperationTypeEnum operationType;

    private BankAccountDto bankAccountDto;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    @JsonProperty("createdDate")
    private OffsetDateTime createdDate = null;

    @Override
    public String toString() {
        return "Operation : " +
                " amount " + amount +
                " operation type : " + operationType +
                " bankAccount Balance : " + bankAccountDto.getBalance() +
                " createdDate : " + createdDate;
    }
}
