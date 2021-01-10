package com.arolla.bankmgm.api.mapper;

import com.arolla.bankmgm.api.domain.Transaction;
import com.arolla.bankmgm.api.model.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.mapper
 */
@Mapper(uses = {DateMapper.class, BankAccountMapper.class})
public interface TransactionMapper {
    @Mapping(target = "bankAccountDto", source = "bankAccount")
    TransactionDto transactionToTransactionDto(Transaction transaction);

    @Mapping(target = "bankAccount", source = "bankAccountDto")
    Transaction transactionDtoToTransaction(TransactionDto transactionDto);
}
