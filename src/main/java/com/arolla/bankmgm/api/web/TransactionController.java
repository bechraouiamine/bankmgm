package com.arolla.bankmgm.api.web;

import com.arolla.bankmgm.api.model.TransactionDto;
import com.arolla.bankmgm.api.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.web
 */
@RequestMapping("/api/v1/bank/transaction")
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("transactions/{iban}")
    public List<TransactionDto> listCustomer(@PathVariable("iban") String iban) {
        return transactionService.findAllTransactionsByIBAN(iban);
    }

    @PostMapping("transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDto placeOrder(@RequestBody TransactionDto transactionDto) {
        return transactionService.executeTransaction(transactionDto);
    }

}
