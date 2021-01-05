package com.arolla.bankmgm.api.mapper;

import com.arolla.bankmgm.api.domain.BankAccount;
import com.arolla.bankmgm.api.domain.Client;
import com.arolla.bankmgm.api.model.BankAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.mapper
 */
@Mapper(uses = {ClientMapper.class})
public interface BankAccountMapper {
    @Mapping(target = "client", source = "clientDto")
    BankAccount bankAccountDtoToBankAccount(BankAccountDto bankAccountDto);

    @Mapping(target = "clientDto", source = "client")
    BankAccountDto bankAccountToBankAccountDto(BankAccount bankAccount);
}
