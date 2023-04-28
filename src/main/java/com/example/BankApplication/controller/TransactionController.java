package com.example.BankApplication.controller;

import com.example.BankApplication.model.Transaction;
import com.example.BankApplication.model.dto.transaction.TransactionMapper;
import com.example.BankApplication.model.dto.transaction.TransactionRequest;
import com.example.BankApplication.model.dto.transaction.TransactionResponse;
import com.example.BankApplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @GetMapping("/api/transactions/{id}")
    public ResponseEntity<List<TransactionResponse>> getAllTransactions(@PathVariable Long id){

        List<Transaction> listOfTransactions = transactionService.findByFromAccountId(id);
        return new ResponseEntity<>(
                listOfTransactions
                        .stream()
                        .map(transactionMapper::map)
                        .collect(Collectors.toList()), HttpStatus.OK
        );
    }

    @GetMapping("/api/all/transactions")
    public ResponseEntity<List<TransactionResponse>> getAllTransactions(){

        List<Transaction> listOfTransactions = transactionService.findAllTransactions();
        return new ResponseEntity<>(
                listOfTransactions
                .stream()
                .map(transactionMapper::map)
                .collect(Collectors.toList()), HttpStatus.OK
                );
    }


    @PostMapping("/api/transactions")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTransaction(@RequestBody TransactionRequest transactionRequest){
        transactionService.createTransaction(transactionRequest);
    }
}
