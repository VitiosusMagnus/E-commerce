package com.enoca.ecommorce.controllers;

import com.enoca.ecommorce.dto.request.CreateCustomerRequest;
import com.enoca.ecommorce.dto.response.GetCustomerResponse;
import com.enoca.ecommorce.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("{id}")
    public GetCustomerResponse getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }
    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }
}
