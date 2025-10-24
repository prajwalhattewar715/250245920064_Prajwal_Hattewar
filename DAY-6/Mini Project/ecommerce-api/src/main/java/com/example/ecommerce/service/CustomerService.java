package com.example.ecommerce.service;

import com.example.ecommerce.dto.CreateCustomerRequest;
import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.repository.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository repo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CustomerService(CustomerRepository repo) { this.repo = repo; }

    public CustomerDto register(CreateCustomerRequest req) {
        if (repo.findByEmail(req.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }
        Customer c = new Customer();
        c.setFirstName(req.getFirstName());
        c.setLastName(req.getLastName());
        c.setEmail(req.getEmail());
        c.setPassword(passwordEncoder.encode(req.getPassword()));
        c.setAddress(req.getAddress());
        c.setPhoneNumber(req.getPhoneNumber());
        Customer saved = repo.save(c);
        return toDto(saved);
    }

    public CustomerDto toDto(Customer c) {
        CustomerDto d = new CustomerDto();
        d.setId(c.getId());
        d.setFirstName(c.getFirstName());
        d.setLastName(c.getLastName());
        d.setEmail(c.getEmail());
        d.setAddress(c.getAddress());
        d.setPhoneNumber(c.getPhoneNumber());
        return d;
    }

    public Customer loadByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    public List<CustomerDto> listAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }
}
