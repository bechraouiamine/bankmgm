package com.arolla.bankmgm.api.services.impl;

import com.arolla.bankmgm.api.mapper.TransactionMapper;
import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.model.TransactionDto;
import com.arolla.bankmgm.api.printers.Printer;
import com.arolla.bankmgm.api.repository.TransactionRepository;
import com.arolla.bankmgm.api.services.BankAccountService;
import com.arolla.bankmgm.api.services.TransactionService;
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
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final BankAccountService bankAccountService;
    private final TransactionMapper transactionMapper;
    private final Printer<TransactionDto> transactionDtoPrinter;

    @Override
    public TransactionDto executeTransaction(TransactionDto transactionDto) {
        BankAccountDto bankAccountDto = bankAccountService.updateBankAccountBalance(transactionDto.getAmount(), transactionDto.getTransactionType(), transactionDto.getBankAccountDto().getIBAN());

        transactionDto.setBankAccountDto(bankAccountDto);

        TransactionDto transactionDtoResult = transactionMapper.transactionToTransactionDto(transactionRepository.save(transactionMapper.transactionDtoToTransaction(transactionDto)));

        transactionDtoPrinter.print(transactionDtoResult);

        return transactionDtoResult;
    }

    @Override
    public List<TransactionDto> findAllTransactionsByIBAN(String IBAN) {
        return transactionRepository.findAllByBankAccountIBAN(IBAN).stream().map(transactionMapper::transactionToTransactionDto).collect(Collectors.toList());

    }
}
