package com.example.BankApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "WITHDRAWS")
public class Withdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    @Column(name = "WITHDRAW_DATE")
    private OffsetDateTime withdrawDate;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
}
