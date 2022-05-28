package com.simple.lgpd.repository;

import com.simple.lgpd.model.CustomerContacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerContactsRepository extends JpaRepository<CustomerContacts, Long> {
}
