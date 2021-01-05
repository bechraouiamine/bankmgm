package com.arolla.bankmgm.api.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 04/01/2021, in com.arolla.bankmgm.service.domain
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    private Client client;

    private BigDecimal balance;

    private String IBAN;

    @OneToMany(mappedBy = "bankAccount")
    private Set<Operation> operations;
}
