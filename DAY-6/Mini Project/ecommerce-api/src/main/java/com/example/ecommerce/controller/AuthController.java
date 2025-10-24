package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CreateCustomerRequest;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.security.JwtUtil;
import com.example.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final CustomerService customerService;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final CustomerRepository customerRepo;

    public AuthController(CustomerService customerService, AuthenticationManager authManager, JwtUtil jwtUtil, CustomerRepository customerRepo) {
        this.customerService = customerService;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.customerRepo = customerRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody CreateCustomerRequest req) {
        var dto = customerService.register(req);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        Customer c = customerRepo.findByEmail(email).orElseThrow();
        String token = jwtUtil.generateToken(email);
        return ResponseEntity.ok(Map.of("token", token, "email", email));
    }
}
