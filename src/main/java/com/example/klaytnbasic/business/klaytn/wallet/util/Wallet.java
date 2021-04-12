package com.example.klaytnbasic.business.klaytn.wallet.util;

import com.example.klaytnbasic.common.util.BasicRestTemplate;
import com.klaytn.caver.Caver;
import com.klaytn.caver.account.Account;
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
public class Wallet {

    private final BasicRestTemplate basicRestTemplate;

    public String create(){
        RestTemplate restTemplate = basicRestTemplate.get();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Your Authorization");
        headers.set("x-chain-id","1001");
        headers.set("x-krn","Your x-krn");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> resultString = restTemplate.exchange("https://wallet-api.klaytnapi.com/v2/account", HttpMethod.POST,entity,String.class);

        return resultString.toString();
    }
}
