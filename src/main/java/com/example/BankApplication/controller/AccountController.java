package com.example.BankApplication.controller;

import com.example.BankApplication.model.dto.account.AccountRequest;
import com.example.BankApplication.model.dto.account.AccountResponse;
import com.example.BankApplication.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/api/account/{id}")
    public ResponseEntity<AccountResponse> findById(@PathVariable long id){
        AccountResponse accountResponse = accountService.find(id);
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @PostMapping("/api/account")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@RequestBody AccountRequest accountRequest){
        accountService.save(accountRequest);
    }
}
