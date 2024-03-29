package com.example.BankApplication.model.dto.transaction;

import com.example.BankApplication.model.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    private BigDecimal amount;
    private String currency;
    private OffsetDateTime transactionDate;
    private long fromAccountId;
    private long toAccountId;
}
