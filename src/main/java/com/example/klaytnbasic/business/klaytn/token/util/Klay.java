package com.example.klaytnbasic.business.klaytn.token.util;

import com.example.klaytnbasic.common.util.BasicRestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class Klay {
    @Value("${klaytn.header.authorization}")
    private String authorization;

    @Value("${klaytn.header.x-chain-id}")
    private String xChainId;

    @Value("${klaytn.header.Content-Type}")
    private String contentType;

    @Value("${klaytn.json-rpc.method.get-balance}")
    private String method;



    private final BasicRestTemplate basicRestTemplate;

    public String getBalance(String address) {
        RestTemplate restTemplate = basicRestTemplate.get();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",authorization);
        headers.set("x-chain-id",xChainId);
        headers.set("Content-Type",contentType);

        String body = "{" +
                "\"method\":\""+method+"\" ," +
                "\"id\":"+1+" ," +
                "\"params\": [\""+address+"\",\"latest\"]" +
                "}";
        System.out.println("body = " + body);
        HttpEntity<?> entity = new HttpEntity<>(body,headers);
        ResponseEntity<String> resultString = restTemplate.exchange("https://node-api.klaytnapi.com/v1/klaytn", HttpMethod.POST,entity,String.class);

        return resultString.toString();
    }
}
