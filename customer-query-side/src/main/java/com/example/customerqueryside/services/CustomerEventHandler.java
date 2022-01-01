package com.example.customerqueryside.services;

import org.springframework.stereotype.Service;
import org.axonframework.eventhandling.EventHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.coreapi.events.CustomerCreatedEvent;
import com.example.customerqueryside.entities.Customer;
import com.example.customerqueryside.repositories.CustomerRepository;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerEventHandler {
  private CustomerRepository customerRepository;

  @EventHandler
  public void on(CustomerCreatedEvent event) {
    log.info("************************");
    log.info("Customer Created Event received");
    Customer customer = new Customer();
    customer.setId(event.getId());
    customer.setName(event.getName());
    customer.setEmail(event.getEmail());
    customerRepository.save(customer);
  }
}
