package com.example.customerqueryside.services;

import org.springframework.stereotype.Service;
import org.axonframework.queryhandling.QueryHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.coreapi.query.GetAllCustomersQuery;
import com.example.coreapi.query.GetCustomerByIdQuery;
import com.example.customerqueryside.entities.Customer;
import com.example.customerqueryside.repositories.CustomerRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerQueryHandler {
  public CustomerRepository customerRepository;

  @QueryHandler
  public List<Customer> customerList(GetAllCustomersQuery query) {
    return customerRepository.findAll();
  }

  @QueryHandler
  public Customer customerList(GetCustomerByIdQuery query) {
    return customerRepository.findById(query.getId())
      .orElseThrow(() -> new RuntimeException("Customer not fount"));
  }
}
