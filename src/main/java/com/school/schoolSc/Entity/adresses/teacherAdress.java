package com.school.schoolSc.Entity.adresses;

import com.school.schoolSc.Entity.teacher;
import jakarta.persistence.*;

@Entity
public class teacherAdress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long adressID;

  @Column(name = "zipcode",nullable = false)
  String zipCode;

  @Column(name = "number",nullable = true)
  int number;


  @Column(name = "complement",nullable = false)
  String complement;

  public com.school.schoolSc.Entity.teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(com.school.schoolSc.Entity.teacher teacher) {
    this.teacher = teacher;
  }

  @ManyToOne
  teacher teacher;

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

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }


  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
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
