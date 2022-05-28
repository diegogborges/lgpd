package com.simple.lgpd.v1.controller;

import com.simple.lgpd.model.CustomerContacts;
import com.simple.lgpd.service.CustomerContactsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/lgpd/customers/contacts")
public class CustomerContactsController {

  @Autowired
  private CustomerContactsService customerContactsService;

  @GetMapping
  public ResponseEntity<List<CustomerContacts>> findAll() {
    List<CustomerContacts> contacts = customerContactsService.findAll();
    return new ResponseEntity<>(contacts, null, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CustomerContacts> save(@RequestBody CustomerContacts customerContacts) {
    CustomerContacts contacts = customerContactsService.save(customerContacts);
    return new ResponseEntity<>(contacts, null, HttpStatus.CREATED);
  }
}
