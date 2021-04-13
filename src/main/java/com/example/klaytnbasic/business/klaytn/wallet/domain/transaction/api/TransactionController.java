package com.example.klaytnbasic.business.klaytn.wallet.domain.transaction.api;

import com.example.klaytnbasic.business.klaytn.wallet.domain.transaction.application.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/tx/klay/transfer")
    public String transferKlay(){
        return transactionService.transferKlay();
    }
}
