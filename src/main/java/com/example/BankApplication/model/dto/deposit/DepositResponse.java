package com.example.BankApplication.model.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepositResponse {
    private BigDecimal amount;
    private String currency;
    private OffsetDateTime depositDate;
}
