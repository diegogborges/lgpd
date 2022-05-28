package com.simple.lgpd.v1.controller;

import com.simple.lgpd.model.Customer;
import com.simple.lgpd.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/lgpd/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public List<Customer> findAll() {
    return customerService.findAll();
  }

  @PostMapping
  public ResponseEntity<Customer> save(@RequestBody Customer customer) {
    final Customer customerResponse = customerService.save(customer);
    return new ResponseEntity<>(customerResponse, null, HttpStatus.CREATED);
  }

  @PutMapping("/{customerId}")
  public ResponseEntity<Customer> update(@RequestBody Customer customer,
                                         @PathVariable Long customerId) {
    final Customer customerResponse = customerService.update(customer, customerId);
    return new ResponseEntity<>(customerResponse, null, HttpStatus.OK);
  }

  @DeleteMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long customerId) {
    customerService.delete(customerId);
  }
}
