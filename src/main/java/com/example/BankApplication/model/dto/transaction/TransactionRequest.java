package com.example.BankApplication.model.dto.transaction;

import com.example.BankApplication.model.Account;
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
    private Account fromAccount;
    private Account toAccount;
}
