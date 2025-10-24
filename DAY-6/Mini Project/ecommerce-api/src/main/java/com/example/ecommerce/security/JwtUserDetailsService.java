package com.example.ecommerce.security;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final CustomerRepository repo;
    public JwtUserDetailsService(CustomerRepository repo) { this.repo = repo; }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer c = repo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return User.withUsername(c.getEmail()).password(c.getPassword()).authorities(Collections.emptyList()).build();
    }
}
