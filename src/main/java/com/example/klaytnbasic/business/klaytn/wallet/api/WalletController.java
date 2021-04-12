package com.example.klaytnbasic.business.klaytn.wallet.api;

import com.example.klaytnbasic.business.klaytn.wallet.application.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/createWallet")
    public String createWallet(){
        return walletService.create();
    }

}
