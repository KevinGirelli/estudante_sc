package com.school.schoolSc.Entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;


@Entity
public class teacher implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long teacherID;

  @Column(name = "email", nullable = false)
  String email;

  @Column(name = "password", nullable = false)
  String password;

  @Column
  private roles role;

  @Column(name = "fullName",nullable = false)
  String fullName;

  public Long getTeacherID() {
    return teacherID;
  }

  public void setTeacherID(Long teacherID) {
    this.teacherID = teacherID;
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

  @Column(name = "cpf",nullable = false)
  String cpf;

  @Column(name = "age",nullable = false)
  Date age;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if(this.role == roles.STUDENT) return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"));
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
