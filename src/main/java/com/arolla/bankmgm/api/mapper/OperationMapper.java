package com.arolla.bankmgm.api.mapper;

import com.arolla.bankmgm.api.domain.Operation;
import com.arolla.bankmgm.api.model.OperationDto;
import org.mapstruct.Mapper;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.mapper
 */
@Mapper
public interface OperationMapper {
    OperationDto operationToOperationDto(Operation operation);

    Operation operationDtoToOperation(OperationDto operationDto);
}
