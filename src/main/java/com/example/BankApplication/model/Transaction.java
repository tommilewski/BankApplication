package com.example.BankApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSACTIONS")
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    @Column(name = "TRANSACTION_DATE")
    private OffsetDateTime transactionDate;

    @Column(name = "FROM_ACCOUNT_ID", nullable = false)
    private long fromAccountId;

    @Column(name = "TO_ACCOUNT_ID", nullable = false)
    private long toAccountId;
}