package com.arolla.bankmgm.api.services.impl;

import com.arolla.bankmgm.api.mapper.OperationMapper;
import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.model.OperationDto;
import com.arolla.bankmgm.api.repository.BankAccountRepository;
import com.arolla.bankmgm.api.repository.OperationRepository;
import com.arolla.bankmgm.api.services.BankAccountService;
import com.arolla.bankmgm.api.services.OperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services.impl
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class OperationServiceImpl implements OperationService {
    public static final String END_EXECUTE_OPERATION = "End executeOperation : ";
    public static final String BEGIN_EXECUTE_OPERATION = "Begin executeOperation : ";

    private final OperationRepository operationRepository;
    private final BankAccountService bankAccountService;
    private final OperationMapper operationMapper;

    @Override
    public OperationDto executeOperation(OperationDto operationDto) {
        log.info(BEGIN_EXECUTE_OPERATION + operationDto);

        BankAccountDto bankAccountDto = bankAccountService.updateBankAccountBalance(operationDto.getAmount(), operationDto.getOperationType(), operationDto.getBankAccountDto().getIBAN());

        operationDto.setBankAccountDto(bankAccountDto);

        OperationDto operationDtoResult = operationMapper.operationToOperationDto(operationRepository.save(operationMapper.operationDtoToOperation(operationDto)));

        log.info(END_EXECUTE_OPERATION + operationDtoResult);
        return operationDtoResult;
    }

    @Override
    public List<OperationDto> findAllOperationByIBAN(String IBAN) {
        return operationRepository.findAllByBankAccountIBAN(IBAN).stream().map(operationMapper::operationToOperationDto).collect(Collectors.toList());

    }
}
