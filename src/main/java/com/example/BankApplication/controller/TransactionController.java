package com.example.BankApplication.controller;

import com.example.BankApplication.model.Transaction;
import com.example.BankApplication.model.dto.client.ClientResponse;
import com.example.BankApplication.model.dto.transaction.TransactionMapper;
import com.example.BankApplication.model.dto.transaction.TransactionRequest;
import com.example.BankApplication.model.dto.transaction.TransactionResponse;
import com.example.BankApplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @GetMapping("/api/all/transactions")
    public ResponseEntity<List<TransactionResponse>> getAllTransactions(){

        List<Transaction> listOfTransactions = transactionService.findAllTransactions();
//        List<TransactionResponse> listOfTransactionsResponse = new ArrayList<>();
//
//        for (Transaction transaction : listOfTransactions) {
//            TransactionResponse transactionResponse = transactionMapper.map(transaction);
//            listOfTransactionsResponse.add(transactionResponse);
//        }
        return new ResponseEntity<>(
                listOfTransactions
                .stream()
                .map(transactionMapper::map)
                .toList(), HttpStatus.OK
                );
    }


    @PostMapping("/api/transactions")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTransaction(@RequestBody TransactionRequest transactionRequest){
        transactionService.createTransaction(transactionRequest);
    }
}
