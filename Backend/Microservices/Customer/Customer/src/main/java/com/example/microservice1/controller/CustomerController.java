package com.example.microservice1.controller;

import com.example.microservice1.table.Customer;
import com.example.microservice1.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping
    public List<Customer> getAllStudents() {
        return customerService.getAllStudents();
    }


    @GetMapping("/{id}")
    public Customer getStudentById(@PathVariable Long id) {
        return customerService.getStudentById(id);
    }


    @PostMapping
    public Customer addStudent(@RequestBody Customer customer) {
        return customerService.addStudent(customer);
    }


    @PutMapping("/{id}")
    public Customer updateStudent(@PathVariable Long id, @RequestBody Customer customerDetails) {
        return customerService.updateStudent(id, customerDetails);
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        customerService.deleteStudent(id);
        return "Student with ID " + id + " has been deleted!";
    }
}
