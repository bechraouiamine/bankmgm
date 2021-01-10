package com.arolla.bankmgm.api.printers.impl;

import com.arolla.bankmgm.api.model.ClientDto;
import com.arolla.bankmgm.api.printers.Printer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by aminebechraoui, on 10/01/2021, in com.arolla.bankmgm.api.printers.impl
 */
@Slf4j
@Component
public class ClientPrinter implements Printer<ClientDto> {
    @Override
    public void print(ClientDto toPrint) {
        log.info(
                "Name : " + toPrint.getName() + SEP +
                        "Last Name : " + toPrint.getLastName()
        );
    }
}
