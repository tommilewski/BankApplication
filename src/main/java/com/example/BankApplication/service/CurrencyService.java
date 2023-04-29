package com.example.BankApplication.service;

import com.example.BankApplication.model.dto.currency.CurrencyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final RestTemplate restTemplate;

    public CurrencyResponse getCurrencyRates(String base){

        String url = "https://api.apilayer.com/exchangerates_data/latest?base=" + base;
        String accessKey = "IpEEpMxcTr4LLR4itM8LKSn9DZeeLljm";

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", accessKey);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        CurrencyResponse response = restTemplate.exchange(url, HttpMethod.GET, entity, CurrencyResponse.class).getBody();

        return response;
    }
}
