package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.model.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.services
 */
@Service
public interface TransactionService {
    TransactionDto executeTransaction(TransactionDto transactionDto);

    List<TransactionDto> findAllTransactionsByIBAN(String IBAN);
}
