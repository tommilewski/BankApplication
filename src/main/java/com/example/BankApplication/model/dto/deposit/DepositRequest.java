package com.example.BankApplication.model.dto.deposit;

import com.example.BankApplication.model.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DepositRequest {


    private BigDecimal amount;

    private String currency;
    private Account account;
}
