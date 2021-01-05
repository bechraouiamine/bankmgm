package com.arolla.bankmgm.api.web;

import com.arolla.bankmgm.api.model.OperationDto;
import com.arolla.bankmgm.api.services.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 05/01/2021, in com.arolla.bankmgm.api.web
 */
@RequestMapping("/api/v1/bank/operation")
@RestController
@RequiredArgsConstructor
public class OperationController {

    private final OperationService operationService;

    @GetMapping("operations/{iban}")
    public List<OperationDto> listCustomer(@PathVariable("iban") String iban) {
        return operationService.findAllOperationByIBAN(iban);
    }

    @PostMapping("operation")
    @ResponseStatus(HttpStatus.CREATED)
    public OperationDto placeOrder(@RequestBody OperationDto operationDto) {
        return operationService.executeOperation(operationDto);
    }

}
