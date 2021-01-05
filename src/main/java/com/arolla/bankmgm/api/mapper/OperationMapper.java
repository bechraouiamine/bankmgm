package com.arolla.bankmgm.api.mapper;

import com.arolla.bankmgm.api.domain.Operation;
import com.arolla.bankmgm.api.model.OperationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.mapper
 */
@Mapper(uses = {DateMapper.class, BankAccountMapper.class})
public interface OperationMapper {
    @Mapping(target = "bankAccountDto", source = "bankAccount")
    OperationDto operationToOperationDto(Operation operation);

    @Mapping(target = "bankAccount", source = "bankAccountDto")
    Operation operationDtoToOperation(OperationDto operationDto);
}
