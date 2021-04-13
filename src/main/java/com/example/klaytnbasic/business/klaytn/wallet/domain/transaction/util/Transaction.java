package com.example.klaytnbasic.business.klaytn.wallet.domain.transaction.util;

import com.example.klaytnbasic.common.util.BasicRestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Transaction {

    @Value("${klaytn.header.authorization}")
    private String authorization;

    @Value("${klaytn.header.x-chain-id}")
    private String xChainId;

    @Value("${klaytn.header.Content-Type}")
    private String contentType;

    @Value("${klaytn.wallet.tx.from.address}")
    private String fromAddress;

    @Value("${klaytn.wallet.tx.to.address}")
    private String toAddress;

    @Value("${klaytn.wallet.tx.value}")
    private String txValue;

    @Value("${klaytn.wallet.tx.submit}")
    private String submit;

    private final BasicRestTemplate basicRestTemplate;

    private final ObjectMapper objectMapper;

    public String transfer(){
        RestTemplate restTemplate = basicRestTemplate.get();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",authorization);
        headers.set("x-chain-id",xChainId);
        headers.set("Content-Type",contentType);

        String body = "{" +
                        "\"from\":\""+fromAddress+"\" ," +
                        "\"to\":\""+toAddress+"\" ," +
                        "\"value\":\""+txValue+"\" ," +
                        "\"submit\":"+submit+
                        "}";

        HttpEntity<?> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> resultString = restTemplate.postForEntity("https://wallet-api.klaytnapi.com/v2/tx/value", entity, String.class);
        return resultString.toString();

    }
}
