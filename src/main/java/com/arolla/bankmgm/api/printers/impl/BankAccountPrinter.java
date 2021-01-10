package com.arolla.bankmgm.api.printers.impl;

import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.printers.Printer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by aminebechraoui, on 10/01/2021, in com.arolla.bankmgm.api.printers.impl
 */
@Slf4j
@Component
public class BankAccountPrinter implements Printer<BankAccountDto> {

    public static final String IBAN = "IBAN : ";
    public static final String BALANCE = "Balance : ";

    @Override
    public void print(BankAccountDto toPrint) {
        log.info(
                IBAN + toPrint.getIBAN() + SEP +
                        BALANCE + toPrint.getBalance()
        );
    }
}
