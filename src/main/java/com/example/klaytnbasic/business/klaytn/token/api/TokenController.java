package com.example.klaytnbasic.business.klaytn.token.api;

import com.example.klaytnbasic.business.klaytn.token.application.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @GetMapping("/token/account/{address}")
    public String findTokenAddress(@PathVariable("address") String address){
        return tokenService.findToken(address);
    }
    @PostMapping("/klay/balance/{address}")
    public String klayBalance(@PathVariable("address") String address){
        return tokenService.klayBalance(address);
    }
}
