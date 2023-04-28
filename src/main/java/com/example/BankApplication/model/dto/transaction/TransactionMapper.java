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
                .fromAccount(transactionRequest.getFromAccount())
                .toAccount(transactionRequest.getToAccount())
                .transactionDate(OffsetDateTime.now())
                .build();
    }

    public TransactionResponse map(Transaction transaction){
        return TransactionResponse
                .builder()
                .amount(transaction.getAmount())
                .currency(transaction.getCurrency())
                .transactionDate(transaction.getTransactionDate())
                .fromAccountId(transaction.getFromAccount().getId())
                .toAccountId(transaction.getToAccount().getId())
                .build();
    }
}
