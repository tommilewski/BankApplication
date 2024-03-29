package com.example.BankApplication.model.dto.currency;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class CurrencyResponse {
    private boolean success;
    private long timestamp;
    private String base;
    private String date;
    private Map<String, BigDecimal> rates;
}
