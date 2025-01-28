package com.example.product.externalapi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
@RequiredArgsConstructor
public class ExternalApiService {

    @Value("${external.api.login-url}")
    private String loginUrl;

    private final RestTemplate restTemplate;


    public String getToken(String username, String password) {
        // Prepare the login request (assuming you need a JSON body with username and password)
        String loginRequestBody = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<String> request = new HttpEntity<>(loginRequestBody, headers);

        // Call the external API to get the token
        ResponseEntity<String> response = restTemplate.exchange(
                loginUrl, HttpMethod.POST, request, String.class);

        // Extract the token from the response (assuming the response contains a field "token")
        String token = response.getBody();  // Adjust as per actual response structure
        return token;
    }
}

