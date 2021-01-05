package com.arolla.bankmgm.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 04/01/2021, in com.arolla.bankmgm.service.model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {
    private UUID id;

    private String name;

    private String lastName;

    private List<BankAccountDto> bankAccountDtos;
}
