package com.example.BankApplication.model.dto.account;

import com.example.BankApplication.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountResponse map(Account account){
        return AccountResponse
                .builder()
                .id(account.getId())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .clientId(account.getClientId())
                .build();
    }

    public Account map(AccountRequest accountRequest){
        return Account
                .builder()
                .balance(accountRequest.getBalance())
                .currency(accountRequest.getCurrency())
                .clientId(accountRequest.getClientId())
                .build();
    }
}
