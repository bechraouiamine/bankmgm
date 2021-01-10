package com.arolla.bankmgm.api.services.impl;

import com.arolla.bankmgm.api.domain.TransactionTypeEnum;
import com.arolla.bankmgm.api.mapper.TransactionMapper;
import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.model.TransactionDto;
import com.arolla.bankmgm.api.printers.Printer;
import com.arolla.bankmgm.api.repository.TransactionRepository;
import com.arolla.bankmgm.api.services.BankAccountService;
import com.arolla.bankmgm.api.services.DepositService;
import com.arolla.bankmgm.api.services.ListTransactionService;
import com.arolla.bankmgm.api.services.WithdrawalService;
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
public class TransactionServiceImpl implements DepositService, WithdrawalService, ListTransactionService {

    private final TransactionRepository transactionRepository;

    private final BankAccountService bankAccountService;

    private final TransactionMapper transactionMapper;

    private final Printer<TransactionDto> transactionDtoPrinter;

    @Override
    public List<TransactionDto> findAllTransactionsByIBAN(String IBAN) {
        return transactionRepository.findAllByBankAccountIBAN(IBAN).stream().map(transactionMapper::transactionToTransactionDto).collect(Collectors.toList());

    }

    @Override
    public TransactionDto depositTransaction(TransactionDto transactionDto) {
        BankAccountDto bankAccountDto = bankAccountService.updateBankAccountBalance(
                transactionDto.getAmount(), TransactionTypeEnum.DEPOSIT, transactionDto.getBankAccountDto().getIBAN()
        );

        transactionDto.setBankAccountDto(bankAccountDto);

        TransactionDto transactionDtoResult = transactionMapper.transactionToTransactionDto(
                transactionRepository.save(
                        transactionMapper.transactionDtoToTransaction(transactionDto)
                )
        );

        transactionDtoPrinter.print(transactionDtoResult);

        return transactionDtoResult;
    }

    @Override
    public TransactionDto withdrawalTransaction(TransactionDto transactionDto) {
        BankAccountDto bankAccountDto = bankAccountService.updateBankAccountBalance(
                transactionDto.getAmount(), TransactionTypeEnum.WITHDRAWAL, transactionDto.getBankAccountDto().getIBAN()
        );

        transactionDto.setBankAccountDto(bankAccountDto);

        TransactionDto transactionDtoResult = transactionMapper.transactionToTransactionDto(
                transactionRepository.save(
                        transactionMapper.transactionDtoToTransaction(transactionDto)
                )
        );

        transactionDtoPrinter.print(transactionDtoResult);

        return transactionDtoResult;
    }
}
