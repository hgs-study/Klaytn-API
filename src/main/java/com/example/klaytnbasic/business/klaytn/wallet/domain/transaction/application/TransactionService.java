package com.example.klaytnbasic.business.klaytn.wallet.domain.transaction.application;

import com.example.klaytnbasic.business.klaytn.wallet.domain.transaction.util.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final Transaction transaction;

    public String transferKlay(){
        return transaction.transfer();
    }
}
