package com.bank.accountservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequest
{
    private String accountType;
    private BigDecimal initialBalance;
    private Long customerId;
}
