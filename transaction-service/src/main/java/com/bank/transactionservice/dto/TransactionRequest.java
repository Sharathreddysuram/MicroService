package com.bank.transactionservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest {

    private Long accountId;

    private BigDecimal amount;

    private String description;
}