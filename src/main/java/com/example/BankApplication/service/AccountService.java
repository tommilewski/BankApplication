package com.example.BankApplication.service;

import com.example.BankApplication.model.Account;
import com.example.BankApplication.model.dto.account.AccountMapper;
import com.example.BankApplication.model.dto.account.AccountRequest;
import com.example.BankApplication.model.dto.account.AccountResponse;
import com.example.BankApplication.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountResponse find(long id) throws IllegalArgumentException{
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Account with " + id + " not found"));
        return accountMapper.map(account);
    }

    public Account save(AccountRequest accountRequest){
        Account account = accountMapper.map(accountRequest);
        return accountRepository.save(account);
    }
}

