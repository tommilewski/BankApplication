package com.example.BankApplication.service;

import com.example.BankApplication.model.Transaction;
import com.example.BankApplication.model.dto.transaction.TransactionMapper;
import com.example.BankApplication.model.dto.transaction.TransactionRequest;
import com.example.BankApplication.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final TransactionMapper transactionMapper;

    public void createTransaction(TransactionRequest transactionRequest){

        accountService.transfer(
                transactionRequest.getFromAccountId(),
                transactionRequest.getToAccountId(),
                transactionRequest.getAmount()
        );

        Transaction transaction = transactionMapper.map(transactionRequest);
        transactionRepository.save(transaction);
    }

}
