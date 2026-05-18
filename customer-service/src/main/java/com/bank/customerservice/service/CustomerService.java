package com.bank.customerservice.service;

import com.bank.customerservice.entity.Customer;
import com.bank.customerservice.exception.CustomerNotFoundException;
import com.bank.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService
{
    private final CustomerRepository customerRepository;
    public Customer createCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }
    public Customer  getCustomerById(Long id)
    {
        return customerRepository.findById(id)
                .orElseThrow(()->
                        new CustomerNotFoundException("Customer not found with ID: " + id));
    }
}
