package com.bank.accountservice.service;

import com.bank.accountservice.client.CustomerClient;
import com.bank.accountservice.dto.AccountRequest;
import com.bank.accountservice.entity.Account;
import com.bank.accountservice.exception.AccountNotFoundException;
import com.bank.accountservice.exception.InsufficientBalanceException;
import com.bank.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerClient customerClient;

    public Account createAccount(AccountRequest request) {

        customerClient.getCustomerById(request.getCustomerId());

        Account account = Account.builder()
                .accountNumber(UUID.randomUUID().toString().substring(0, 10))
                .accountType(request.getAccountType())
                .balance(request.getInitialBalance())
                .customerId(request.getCustomerId())
                .createdAt(LocalDateTime.now())
                .build();

        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found with ID: " + accountId));
    }

    public Account deposit(Long accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);

        account.setBalance(account.getBalance().add(amount));

        return accountRepository.save(account);
    }

    public Account withdraw(Long accountId, BigDecimal amount) {
        Account account = getAccountById(accountId);

        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(amount));

        return accountRepository.save(account);
    }
}