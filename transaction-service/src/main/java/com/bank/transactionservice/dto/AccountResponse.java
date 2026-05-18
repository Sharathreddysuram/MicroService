package com.bank.transactionservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountResponse {

    private Long accountId;

    private String accountNumber;

    private String accountType;

    private BigDecimal balance;

    private Long customerId;

    private LocalDateTime createdAt;
}