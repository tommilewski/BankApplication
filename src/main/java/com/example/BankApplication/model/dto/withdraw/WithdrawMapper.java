package com.example.BankApplication.model.dto.withdraw;

import com.example.BankApplication.model.Withdraw;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class WithdrawMapper {

    public WithdrawResponse map(Withdraw withdraw){
        return WithdrawResponse
                .builder()
                .amount(withdraw.getAmount())
                .withdrawDate(withdraw.getWithdrawDate())
                .currency(withdraw.getCurrency())
                .build();
    }

    public Withdraw map(WithdrawRequest withdrawRequest){
        return Withdraw
                .builder()
                .amount(withdrawRequest.getAmount())
                .currency(withdrawRequest.getCurrency())
                .account(withdrawRequest.getAccount())
                .withdrawDate(OffsetDateTime.now())
                .build();
    }
}
