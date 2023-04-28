package com.example.BankApplication.model.dto.deposit;

import com.example.BankApplication.model.Deposit;

public class DepositMapper {

    public DepositResponse map(Deposit deposit){
        return DepositResponse
                .builder()
                .amount(deposit.getAmount())
                .depositDate(deposit.getDepositDate())
                .currency(deposit.getCurrency())
                .build();
    }

    public Deposit map(DepositRequest depositRequest){
        return Deposit
                .builder()
                .amount(depositRequest.getAmount())
                .currency(depositRequest.getCurrency())
                .account(depositRequest.getAccount())
                .build();
    }
}
