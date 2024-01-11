package com.school.schoolSc.Entity.adresses;

import com.school.schoolSc.Entity.student;
import jakarta.persistence.*;

@Entity
public class instituicaoAdress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long adressID;

  @Column(name = "zipcode",nullable = false)
  String zipCode;

  public Long getAdressID() {
    return adressID;
  }

  public void setAdressID(Long adressID) {
    this.adressID = adressID;
  }


  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public com.school.schoolSc.Entity.student getStudent() {
    return student;
  }

  public void setStudent(com.school.schoolSc.Entity.student student) {
    this.student = student;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Column(name = "neighborhood",nullable = false)
  String neighborhood;

  @ManyToOne
  com.school.schoolSc.Entity.student student;

  @Column(name = "city",nullable = false)
  String city;

  @Column(name = "state",nullable = false)
  String state;

}
