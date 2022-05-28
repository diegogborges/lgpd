package com.simple.lgpd.service;

import com.simple.lgpd.model.CustomerContacts;
import com.simple.lgpd.repository.CustomerContactsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactsService {

  @Autowired
  private CustomerContactsRepository customerContactsRepository;

  public List<CustomerContacts> findAll() {
    return customerContactsRepository.findAll();
  }

  public CustomerContacts save(CustomerContacts customerContacts) {
    return customerContactsRepository.save(customerContacts);
  }
}
