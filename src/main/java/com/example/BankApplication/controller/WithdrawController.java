package com.example.BankApplication.controller;

import com.example.BankApplication.model.dto.withdraw.WithdrawRequest;
import com.example.BankApplication.model.dto.withdraw.WithdrawResponse;
import com.example.BankApplication.service.WithdrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WithdrawController {

    private final WithdrawService withdrawService;

    @GetMapping("api/withdraw/{id}")
    public ResponseEntity<List<WithdrawResponse>> findByAccountId(@PathVariable long id){
        List<WithdrawResponse> depositsResponse = withdrawService.findByAccountId(id);
        return new ResponseEntity<>(depositsResponse, HttpStatus.OK);
    }

    @PostMapping("api/withdraw")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@RequestBody WithdrawRequest withdrawRequest){
        withdrawService.createWithdrawMoney(withdrawRequest);

    }
}
