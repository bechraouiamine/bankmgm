package com.arolla.bankmgm.api.printers.impl;

import com.arolla.bankmgm.api.model.TransactionDto;
import com.arolla.bankmgm.api.printers.Printer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by aminebechraoui, on 10/01/2021, in com.arolla.bankmgm.api.printers.impl
 */
@Slf4j
@Component
public class TransactionPrinter implements Printer<TransactionDto> {

    public static final String AMOUNT = "Amount : ";
    public static final String TRANSACTION_TYPE = "Transaction Type : ";
    public static final String BANK_IBAN = "Bank Iban : ";


    @Override
    public void print(TransactionDto toPrint) {
        log.info(
                AMOUNT + toPrint.getAmount() + SEP +
                        TRANSACTION_TYPE + toPrint.getTransactionType() + SEP +
                        BANK_IBAN + toPrint.getBankAccountDto().getIBAN() + SEP
        );

    }
}
