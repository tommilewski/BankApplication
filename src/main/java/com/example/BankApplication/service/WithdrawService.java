package com.example.BankApplication.service;

import com.example.BankApplication.model.Withdraw;
import com.example.BankApplication.model.dto.withdraw.WithdrawMapper;
import com.example.BankApplication.model.dto.withdraw.WithdrawRequest;
import com.example.BankApplication.model.dto.withdraw.WithdrawResponse;
import com.example.BankApplication.repository.WithdrawRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WithdrawService {

    private final WithdrawMapper withdrawMapper;
    private final WithdrawRepository withdrawRepository;
    private final AccountService accountService;

    public List<WithdrawResponse> findByAccountId(long id){
        return withdrawRepository.findByAccountId(id)
                .stream()
                .map(withdrawMapper::map)
                .collect(Collectors.toList());



    }
    public void createWithdrawMoney(WithdrawRequest withdrawRequest){

        accountService.withdrawMoney(withdrawRequest.getAccount().getId(), withdrawRequest.getAmount());
        Withdraw withdraw = withdrawMapper.map(withdrawRequest);

        withdrawRepository.save(withdraw);

    }
}
