package com.example.klaytnbasic.business.klaytn.token.application;

import com.example.klaytnbasic.business.klaytn.token.util.TokenHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenHistory tokenHistory;

    public String findToken(String address){
        return tokenHistory.find(address);
    }

}
