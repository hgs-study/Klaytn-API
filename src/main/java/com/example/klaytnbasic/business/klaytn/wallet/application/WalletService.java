package com.example.klaytnbasic.business.klaytn.wallet.application;

import com.example.klaytnbasic.business.klaytn.wallet.util.Wallet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final Wallet wallet;

    public String create(){
        return wallet.create();
    }
}
