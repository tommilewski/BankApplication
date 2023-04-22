package com.example.BankApplication.service;

import com.example.BankApplication.model.Account;
import com.example.BankApplication.model.dto.account.AccountMapper;
import com.example.BankApplication.model.dto.account.AccountRequest;
import com.example.BankApplication.model.dto.account.AccountResponse;
import com.example.BankApplication.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    public void transfer(long fromAccountId, long toAccountId, BigDecimal amount){
        validateAmount(amount);
        validateAccounts(fromAccountId, toAccountId);

        Account fromAccount;
        Account toAccount;

        if (accountRepository.findById(fromAccountId).isPresent()){
            fromAccount = accountRepository.findById(fromAccountId).get();
        } else {
            throw new IllegalArgumentException("Account with " + fromAccountId + " id does not exist");
        }

        if (accountRepository.findById(toAccountId).isPresent()){
            toAccount = accountRepository.findById(toAccountId).get();
        } else {
            throw new IllegalArgumentException("Account with " + toAccountId + " id does not exist");
        }

        BigDecimal fromAccountResult = fromAccount.getBalance().subtract(amount);
        if (fromAccountResult.compareTo(new BigDecimal("0")) > 0){
            fromAccount.setBalance(fromAccountResult);
            BigDecimal toAccountResult = toAccount.getBalance().add(amount);
            toAccount.setBalance(toAccountResult);
        } else {
            throw new IllegalArgumentException("No enough money");
        }

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);


    }

    private void validateAmount(BigDecimal amount){
        if (amount.compareTo(new BigDecimal("0")) <= 0){
            throw new IllegalArgumentException("Amount cannot be smaller than 0");
        }
    }
    private void validateAccounts(long fromAccountId, long toAccountId){
        if (fromAccountId == toAccountId){
            throw new IllegalArgumentException("Accounts are the same");
        }
    }
}

