package com.school.schoolSc.Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "adress")
public class adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long adressID;

    @Column(name = "street",nullable = false)
    String street;

    @Column(name = "zipcode",nullable = false)
    String zipCode;

    @Column(name = "number",nullable = true)
    int number;

    @Column(name = "neighborhood",nullable = false)
    String neighborhood;

    @Column(name = "complement",nullable = false)
    String complement;

    @Column(name = "apartmentNumber",nullable = true)
    int apartmentNumber;

    @Column(name = "city",nullable = false)
    String city;

    @Column(name = "state",nullable = false)
    String state;

}
