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

    public void save(AccountRequest accountRequest){
        Account account = accountMapper.map(accountRequest);
        accountRepository.save(account);
    }

    public void transfer(long fromAccountId, long toAccountId, BigDecimal amount){
        validateAmount(amount);
        validateAccounts(fromAccountId, toAccountId);

        Account fromAccount = checkIfAccountExist(fromAccountId);
        Account toAccount = checkIfAccountExist(toAccountId);

        BigDecimal fromAccountResult = fromAccount.getBalance().subtract(amount);
        if (fromAccountResult.compareTo(new BigDecimal("0")) > 0){
            fromAccount.setBalance(fromAccountResult);
            BigDecimal toAccountResult = toAccount.getBalance().add(amount);
            toAccount.setBalance(toAccountResult);
        } else {
            throw new IllegalArgumentException("Not enough money");
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

    private Account checkIfAccountExist(long id) throws IllegalArgumentException{

        if (accountRepository.findById(id).isPresent()){
            return accountRepository.findById(id).get();
        } else {
            throw new IllegalArgumentException("Account with " + id + " id does not exist");
        }
    }

    public void depositMoney(long accountId, BigDecimal amount){
        validateAmount(amount);
        Account account = checkIfAccountExist(accountId);

        BigDecimal result = account.getBalance().add(amount);
        account.setBalance(result);
        accountRepository.save(account);
    }

    public void withdrawMoney(long accountId, BigDecimal amount){
        validateAmount(amount);
        Account account = checkIfAccountExist(accountId);

        BigDecimal result = account.getBalance().subtract(amount);
        if (result.compareTo(new BigDecimal("0")) > 0){
            account.setBalance(result);
        } else {
            throw new IllegalArgumentException("Not enough money");
        }

        account.setBalance(result);
        accountRepository.save(account);
    }
}

