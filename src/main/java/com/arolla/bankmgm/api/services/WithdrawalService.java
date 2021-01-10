package com.arolla.bankmgm.api.services;

import com.arolla.bankmgm.api.model.TransactionDto;

/**
 * Created by aminebechraoui, on 10/01/2021, in com.arolla.bankmgm.api.services
 */
public interface WithdrawalService {
    TransactionDto withdrawalTransaction(TransactionDto transactionDto);
}
