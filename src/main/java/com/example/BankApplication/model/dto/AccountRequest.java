package com.example.BankApplication.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AccountRequest {
    private BigDecimal balance;
    private String currency;
    private Long clientId;
}
