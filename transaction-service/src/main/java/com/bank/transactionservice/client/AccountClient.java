package com.bank.transactionservice.client;

import com.bank.transactionservice.dto.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountClient {

    @GetMapping("/api/accounts/{accountId}")
    AccountResponse getAccountById(@PathVariable Long accountId);

    @PutMapping("/api/accounts/{accountId}/deposit")
    AccountResponse deposit(@PathVariable Long accountId,
                            @RequestParam BigDecimal amount);

    @PutMapping("/api/accounts/{accountId}/withdraw")
    AccountResponse withdraw(@PathVariable Long accountId,
                             @RequestParam BigDecimal amount);
}