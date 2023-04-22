package com.example.BankApplication.model.dto.transaction;

import com.example.BankApplication.model.Transaction;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class TransactionMapper {

    public Transaction map(TransactionRequest transactionRequest){
        return Transaction
                .builder()
                .amount(transactionRequest.getAmount())
                .currency(transactionRequest.getCurrency())
                .fromAccountId(transactionRequest.getFromAccountId())
                .toAccountId(transactionRequest.getToAccountId())
                .transactionDate(OffsetDateTime.now())
                .build();
    }
}
