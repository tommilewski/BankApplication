package com.example.BankApplication.model.dto.withdraw;

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
public class WithdrawResponse {

    private BigDecimal amount;
    private String currency;
    private OffsetDateTime withdrawDate;
}
