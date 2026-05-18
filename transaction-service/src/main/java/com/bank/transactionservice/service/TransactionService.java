package com.bank.transactionservice.service;

import com.bank.transactionservice.client.AccountClient;
import com.bank.transactionservice.dto.TransactionRequest;
import com.bank.transactionservice.entity.Transaction;
import com.bank.transactionservice.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;

    public Transaction deposit(TransactionRequest request) {

        accountClient.deposit(request.getAccountId(), request.getAmount());

        Transaction transaction = Transaction.builder()
                .accountId(request.getAccountId())
                .transactionType("DEPOSIT")
                .amount(request.getAmount())
                .status("SUCCESS")
                .description(request.getDescription())
                .transactionDate(LocalDateTime.now())
                .build();

        return transactionRepository.save(transaction);
    }

    public Transaction withdraw(TransactionRequest request) {

        accountClient.withdraw(request.getAccountId(), request.getAmount());

        Transaction transaction = Transaction.builder()
                .accountId(request.getAccountId())
                .transactionType("WITHDRAW")
                .amount(request.getAmount())
                .status("SUCCESS")
                .description(request.getDescription())
                .transactionDate(LocalDateTime.now())
                .build();

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}