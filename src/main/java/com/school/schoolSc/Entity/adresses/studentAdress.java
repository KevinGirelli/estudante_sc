package com.school.schoolSc.Entity.adresses;

import com.school.schoolSc.Entity.student;
import jakarta.persistence.*;

@Entity
public class studentAdress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long adressID;

    @Column(name = "zipcode",nullable = false)
    String zipCode;

    @Column(name = "number",nullable = true)
    int number;

    @Column(name = "complement",nullable = false)
    String complement;

    @ManyToOne
    student student;

    @Column(name = "city",nullable = false)
    String city;

    @Column(name = "state",nullable = false)
    String state;


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

    public com.school.schoolSc.Entity.student getStudent() {
        return student;
    }

    public void setStudent(com.school.schoolSc.Entity.student student) {
        this.student = student;
    }

    public void setState(String state) {
        this.state = state;
    }


}
