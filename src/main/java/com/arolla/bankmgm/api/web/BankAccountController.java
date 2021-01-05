package com.arolla.bankmgm.api.web;

import com.arolla.bankmgm.api.model.BankAccountDto;
import com.arolla.bankmgm.api.model.OperationDto;
import com.arolla.bankmgm.api.services.BankAccountService;
import com.arolla.bankmgm.api.services.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.web
 */
@RequestMapping("/api/v1/bank/bankaccount")
@RestController
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("bankaccounts/{iban}")
    public BankAccountDto listCustomer(@PathVariable("iban") String iban) {
        return bankAccountService.findByIBAN(iban);
    }
}
