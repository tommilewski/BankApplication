package com.example.BankApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BankApplication.class, args);
		HttpHeaders httpHeaders = new HttpHeaders();
		String url = "https://api.exchangeratesapi.io/v1/latest";
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("access_key", "nYAlTG0eCVAS5W2NLqcjpjs8evZxOVJF");
		uriVariables.put("base", "USD");

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, uriVariables);
		System.out.println(response.getBody());
	}

}
