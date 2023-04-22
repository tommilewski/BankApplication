package com.example.BankApplication.model.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private BigDecimal amount;
    private String currency;
    private long fromAccountId;
    private long toAccountId;
}
