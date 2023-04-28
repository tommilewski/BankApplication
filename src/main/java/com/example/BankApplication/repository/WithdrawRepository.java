package com.example.BankApplication.repository;

import com.example.BankApplication.model.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawRepository extends JpaRepository<Withdraw, Long> {

    List<Withdraw> findByAccountId(long id);
}
