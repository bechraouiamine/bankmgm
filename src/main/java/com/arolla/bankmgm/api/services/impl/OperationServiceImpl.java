package com.arolla.bankmgm.api.services.impl;

import com.arolla.bankmgm.api.mapper.OperationMapper;
import com.arolla.bankmgm.api.model.OperationDto;
import com.arolla.bankmgm.api.repository.BankAccountRepository;
import com.arolla.bankmgm.api.repository.OperationRepository;
import com.arolla.bankmgm.api.services.BankAccountService;
import com.arolla.bankmgm.api.services.OperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services.impl
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    public static final String END_EXECUTE_OPERATION = "End executeOperation : ";
    public static final String BEGIN_EXECUTE_OPERATION = "Begin executeOperation : ";

    private final OperationRepository operationRepository;
    private final BankAccountService bankAccountService;
    private final OperationMapper operationMapper;

    @Override
    public OperationDto executeOperation(OperationDto operationDto) {
        log.info(BEGIN_EXECUTE_OPERATION);

        log.info(END_EXECUTE_OPERATION);
        return null;
    }

    @Override
    public List<OperationDto> findAllOperationByIBAN(String IBAN) {
        return null;
    }
}
