package com.example.BankApplication.service;

import com.example.BankApplication.model.Deposit;
import com.example.BankApplication.model.dto.deposit.DepositMapper;
import com.example.BankApplication.model.dto.deposit.DepositRequest;
import com.example.BankApplication.model.dto.deposit.DepositResponse;
import com.example.BankApplication.repository.DepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepositService {

    private final DepositMapper depositMapper;
    private final DepositRepository depositRepository;
    private final AccountService accountService;

    public List<DepositResponse> findByAccountId(long id){
        return depositRepository.findByAccountId(id)
                .stream()
                .map(depositMapper::map)
                        .collect(Collectors.toList());



    }
    public void createWithdrawMoney(DepositRequest depositRequest){

        accountService.withdrawMoney(depositRequest.getAccount().getId(), depositRequest.getAmount());
        Deposit deposit = depositMapper.map(depositRequest);

        depositRepository.save(deposit);

    }
}
