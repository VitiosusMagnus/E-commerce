package com.enoca.ecommorce.services;

import com.enoca.ecommorce.dto.request.CreateCustomerRequest;
import com.enoca.ecommorce.dto.response.GetCustomerResponse;
import com.enoca.ecommorce.entities.concretes.Cart;
import com.enoca.ecommorce.entities.concretes.Customer;
import com.enoca.ecommorce.entities.concretes.Order;
import com.enoca.ecommorce.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public GetCustomerResponse getCustomer(long id) {
        return modelMapper.map(customerRepository.findById(id).get(),
                GetCustomerResponse.class);
    }

    public void createCustomer(CreateCustomerRequest request) {
        Customer customer = modelMapper.map(request, Customer.class);
        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);
        customerRepository.save(customer);
    }
}
