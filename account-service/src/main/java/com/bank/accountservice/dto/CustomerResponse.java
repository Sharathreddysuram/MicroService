package com.bank.accountservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerResponse
{

    private Long customerId;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String email;

    private String phone;

    private String address;
}
