package com.example.BankApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "ACCOUNTS")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    @Column(name = "CLIENT_ID")
    private Long clientId;
}
