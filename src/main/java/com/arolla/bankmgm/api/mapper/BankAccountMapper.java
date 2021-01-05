package com.arolla.bankmgm.api.mapper;

import com.arolla.bankmgm.api.domain.BankAccount;
import com.arolla.bankmgm.api.model.BankAccountDto;
import org.mapstruct.Mapper;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.mapper
 */
@Mapper
public interface BankAccountMapper {
    BankAccount bankAccountDtoToBankAccount(BankAccountDto bankAccountDto);

    BankAccountDto bankAccountToBankAccountDto(BankAccount bankAccount);
}
