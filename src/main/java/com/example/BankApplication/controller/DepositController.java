package com.example.BankApplication.controller;

import com.example.BankApplication.model.dto.deposit.DepositRequest;
import com.example.BankApplication.model.dto.deposit.DepositResponse;
import com.example.BankApplication.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepositController {

    private final DepositService depositService;

    @GetMapping("api/deposit/{id}")
    public ResponseEntity<List<DepositResponse>> findByAccountId(@PathVariable long id){
        List<DepositResponse> depositsResponse = depositService.findByAccountId(id);
        return new ResponseEntity<>(depositsResponse, HttpStatus.OK);
    }

    @PostMapping("api/deposit")
    public void save(@RequestBody DepositRequest depositRequest){
        depositService.createWithdrawMoney(depositRequest);

    }
}
