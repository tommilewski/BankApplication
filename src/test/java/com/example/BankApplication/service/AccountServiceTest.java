package com.example.BankApplication.service;

import com.example.BankApplication.model.Account;
import com.example.BankApplication.model.dto.account.AccountMapper;
import com.example.BankApplication.model.dto.account.AccountResponse;
import com.example.BankApplication.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AccountMapper accountMapper;
    @InjectMocks
    private AccountService underTest;

    @Test
    public void transferTheSameAccounts(){
        //given
        long id = 1L;
        BigDecimal amount = new BigDecimal("100");
        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.transfer(id, id, amount));

    }

    @Test
    public void transferZeroAmount(){
        long fromId = 1L;
        long toId = 2L;
        BigDecimal amount = new BigDecimal("0");

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.transfer(fromId, toId, amount));
    }

    @Test
    public void transferMinusAmount(){
        long fromId = 1L;
        long toId = 2L;
        BigDecimal amount = new BigDecimal("-100");

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.transfer(fromId, toId, amount));
    }

    @Test
    public void transferCorrectly(){
        //given
        long fromId = 1L;
        long toId = 2L;
        BigDecimal amount = new BigDecimal("20");
        Account acc1 = new Account(fromId, new BigDecimal("100"), "PLN", 5L);
        Account acc2 = new Account(toId, new BigDecimal("50"), "PLN", 4L);

        //when
        when(accountRepository.findById(fromId)).thenReturn(Optional.of(acc1));
        when(accountRepository.findById(toId)).thenReturn(Optional.of(acc2));

        //then
        underTest.transfer(fromId, toId, amount);

        Assertions.assertEquals(new BigDecimal("80"), acc1.getBalance());
        Assertions.assertEquals(new BigDecimal("70"), acc2.getBalance());
    }

    @Test
    public void transferWithNotEnoughMoney(){
        //given
        long fromId = 1L;
        long toId = 2L;
        BigDecimal amount = new BigDecimal("1000");
        Account acc1 = new Account(fromId, new BigDecimal("100"), "PLN", 5L);
        Account acc2 = new Account(toId, new BigDecimal("50"), "PLN", 4L);

        //when
        when(accountRepository.findById(fromId)).thenReturn(Optional.of(acc1));
        when(accountRepository.findById(toId)).thenReturn(Optional.of(acc2));

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.transfer(fromId, toId, amount));
    }

    @Test
    public void findAccountCorrectly(){
        //given
        long id = 1L;
        Account account = new Account(id, new BigDecimal("100"), "PLN", 2L);
        //when
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        when(accountMapper.map(account)).thenReturn(new AccountResponse(id, new BigDecimal("100"), "PLN", 2L));

        //then
        AccountResponse result = underTest.find(id);

        Assertions.assertEquals(account.getId(), result.getId());
        Assertions.assertEquals(account.getClientId(), result.getClientId());
    }

    @Test
    public void findAccountDoesNotExist(){
        //given
        long id = 1L;
        //when
        when(accountRepository.findById(id)).thenThrow(new IllegalArgumentException());

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.find(id));
    }

    @Test
    public void depositMoneyCorrectly(){
        //given
        long id = 1L;
        Account acc = new Account(id, new BigDecimal("100"), "PLN", 5L );

        //when
        when(accountRepository.findById(id)).thenReturn(Optional.of(acc));

        //then
        underTest.depositMoney(id,new BigDecimal("10"));

        Assertions.assertEquals(new BigDecimal("110"), acc.getBalance());
    }

    @Test
    public void depositMoneyWithAccountDoesNotExist(){
        //given
        long id = 1L;

        //when
        when(accountRepository.findById(id)).thenReturn(Optional.empty());

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.depositMoney(id,
                new BigDecimal("10")));
    }

}