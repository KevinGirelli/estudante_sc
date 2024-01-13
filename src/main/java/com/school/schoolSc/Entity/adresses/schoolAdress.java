package com.school.schoolSc.Entity.adresses;

import com.school.schoolSc.Entity.schools;
import jakarta.persistence.*;

@Entity
public class schoolAdress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long adressID;

  @Column(name = "zipcode",nullable = false)
  String zipCode;

  @ManyToOne
  schools school;

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

  public schools getSchool() {
    return school;
  }

  public void setSchool(schools school) {
    this.school = school;
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


  @Column(name = "city",nullable = false)
  String city;

  @Column(name = "state",nullable = false)
  String state;

}
