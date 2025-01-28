package com.example.microservice1.repo;

import com.example.microservice1.table.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
