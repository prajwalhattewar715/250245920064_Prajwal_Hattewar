package com.example.customerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.web.servlet.ViewResolver;

import jakarta.persistence.*;
import java.util.List;

@SpringBootApplication
public class CustomerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerAppApplication.class, args);
    }

    @Bean
    public ViewResolver viewResolver() {
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        return resolver;
    }

    @Entity
    public static class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;

        public Customer() {}
        public Customer(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    public interface CustomerRepository extends JpaRepository<Customer, Long> {}

    @Controller
    @RequestMapping("/customers")
    public static class CustomerController {

        private final CustomerRepository repository;

        public CustomerController(CustomerRepository repository) {
            this.repository = repository;
        }

        @GetMapping
        public String listCustomers(Model model) {
            model.addAttribute("customers", repository.findAll());
            return "customers";
        }

        @GetMapping("/add")
        public String addCustomerForm(Model model) {
            model.addAttribute("customer", new Customer());
            return "addCustomer";
        }

        @PostMapping("/add")
        public String saveCustomer(@ModelAttribute Customer customer) {
            repository.save(customer);
            return "redirect:/customers";
        }

        @GetMapping("/edit/{id}")
        public String editCustomerForm(@PathVariable Long id, Model model) {
            Customer customer = repository.findById(id).orElseThrow();
            model.addAttribute("customer", customer);
            return "editCustomer";
        }

        @PostMapping("/edit")
        public String updateCustomer(@ModelAttribute Customer customer) {
            repository.save(customer);
            return "redirect:/customers";
        }
    }
}