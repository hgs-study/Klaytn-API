package com.example.klaytnbasic.business.klaytn.token.util;

import com.example.klaytnbasic.common.util.BasicRestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TokenHistory {

    private final BasicRestTemplate basicRestTemplate;

    public String find(String address) {

        RestTemplate restTemplate = basicRestTemplate.get();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Your Authorization");
        headers.set("x-chain-id","1001");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> resultString = restTemplate.exchange("https://th-api.klaytnapi.com/v2/transfer/account/"+address, HttpMethod.GET,entity,String.class);

        return resultString.toString();
    }
}
