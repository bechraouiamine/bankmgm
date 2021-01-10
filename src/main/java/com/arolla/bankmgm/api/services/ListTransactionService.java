package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.model.TransactionDto;

import java.util.List;

/**
 * Created by aminebechraoui, on 10/01/2021, in com.arolla.bankmgm.api.services
 */
public interface ListTransactionService {
    List<TransactionDto> findAllTransactionsByIBAN(String IBAN);
}
