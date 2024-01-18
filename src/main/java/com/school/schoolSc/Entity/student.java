package com.school.schoolSc.Entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
public class student implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long studentID;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Column(nullable = true)
    private roles role;

    @Column(name = "fullName", nullable = false)
    String fullName;

    @Column(name = "cpf", nullable = false)
    String cpf;

    @Column(name = "age",nullable = false)
    Date age;

    @Column(name = "registration", nullable = false)
    String registration;

    @Column(name = "parentName",nullable = false)
    String parentName;

    @Column(name = "parentPhoneNumber",nullable = false)
    String parentPhoneNumber;

    @Column(name = "parentCPF",nullable = false)
    String parentCPF;

    @Column(name = "zipcode",nullable = false)
    String zipCode;

    @Column(name = "number",nullable = true)
    int number;

    @Column(name = "complement",nullable = false)
    String complement;

    @Column(name = "city",nullable = false)
    String city;

    @Column(name = "state",nullable = false)
    String state;


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

    public student(){}

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public roles getRole() {
        return role;
    }

    public void setRole(roles role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getParentCPF() {
        return parentCPF;
    }

    public void setParentCPF(String parentCPF) {
        this.parentCPF = parentCPF;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == roles.STUDENT) return List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));
        else{
            return null;
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
