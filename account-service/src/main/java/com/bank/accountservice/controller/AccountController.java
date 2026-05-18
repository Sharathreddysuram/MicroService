package com.bank.accountservice.controller;

import com.bank.accountservice.dto.AccountRequest;
import com.bank.accountservice.entity.Account;
import com.bank.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody AccountRequest request) {
        return accountService.createAccount(request);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @PutMapping("/{accountId}/deposit")
    public Account deposit(@PathVariable Long accountId,
                           @RequestParam BigDecimal amount) {
        return accountService.deposit(accountId, amount);
    }

    @PutMapping("/{accountId}/withdraw")
    public Account withdraw(@PathVariable Long accountId,
                            @RequestParam BigDecimal amount) {
        return accountService.withdraw(accountId, amount);
    }
}