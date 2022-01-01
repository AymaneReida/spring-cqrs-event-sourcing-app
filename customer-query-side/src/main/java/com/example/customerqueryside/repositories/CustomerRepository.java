package com.example.customerqueryside.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customerqueryside.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
