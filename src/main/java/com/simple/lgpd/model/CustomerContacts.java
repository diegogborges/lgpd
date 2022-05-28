package com.simple.lgpd.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "customer_contacts")
public class CustomerContacts implements Serializable {


  private static final long serialVersionUID = 1971119915211828900L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String description;

  @Type(type = "numeric_boolean")
  private Boolean status;

  @ManyToOne
  @JoinColumn(
      name = "customer_id", nullable = false,
      foreignKey = @ForeignKey(name = "FK_CUSTOMER_CUSTOMER_CONTACTS")
  )
  private Customer customer;

  public CustomerContacts() {
  }

  public CustomerContacts(Long id, String description, Boolean status, Customer customer) {
    this.id = id;
    this.description = description;
    this.status = status;
    this.customer = customer;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
