package com.example.BankApplication.service;

import com.example.BankApplication.model.Account;
import com.example.BankApplication.model.dto.AccountRequest;
import com.example.BankApplication.model.dto.AccountResponse;
import com.example.BankApplication.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResponse find(long id) throws IllegalAccessException {
        return accountRepository
                .findById(id)
                .map(account ->
                        AccountResponse.builder()
                                .balance(account.getBalance())
                                .currency(account.getCurrency())
                                .clientId(account.getClientId())
                                .id(account.getId())
                                .build())
                .orElseThrow(() -> new IllegalAccessException("Account with " + id + " not found"));
    }

    public Account save(AccountRequest accountRequest){
        return accountRepository.save(
                Account.builder()
                        .balance(accountRequest.getBalance())
                        .clientId(accountRequest.getClientId())
                        .currency(accountRequest.getCurrency())
                        .build());
    }
}

