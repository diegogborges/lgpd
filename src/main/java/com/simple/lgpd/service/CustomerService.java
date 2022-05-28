package com.simple.lgpd.service;

import com.simple.lgpd.exception.NotFoundException;
import com.simple.lgpd.model.Customer;
import com.simple.lgpd.repository.CustomerRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  public Customer save(Customer customer) {
    customer.setUuid(UUID.randomUUID());
    return customerRepository.save(customer);
  }

  public Customer findById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Customer not found"));
  }

  public Customer update(Customer customerRequest, Long customerId) {
    Customer customer = findById(customerId);
    customer.setEmail(customerRequest.getEmail());
    customer.setName(customerRequest.getName());
    customer.setPhone(customerRequest.getPhone());
    return customerRepository.save(customer);
  }

  public void delete(Long customerId) {
    Customer customer = findById(customerId);
    customerRepository.delete(customer);
  }
}
