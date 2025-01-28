package com.example.microservice1.Services;

import com.example.microservice1.table.Customer;
import com.example.microservice1.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllStudents() {
        return customerRepository.findAll();
    }


    public Customer getStudentById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found!"));
    }

    public Customer addStudent(Customer customer) {
        return customerRepository.save(customer);
    }


    public Customer updateStudent(Long id, Customer customerDetails) {
        Customer customer = getStudentById(id);
        customer.setName(customerDetails.getName());
        customer.setEmail(customer.getEmail());
        return customerRepository.save(customer);
    }


    public void deleteStudent(Long id) {
        customerRepository.deleteById(id);
    }
}
