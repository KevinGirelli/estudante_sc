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

  @Column(name = "firstName",nullable = false)
  String firstName;

  @Column(name = "lastName",nullable = false)
  String lastName;

  @Column(name = "cpf",nullable = false)
  String cpf;

  @Column(name = "age",nullable = false)
  Date age;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if(this.role == roles.STUDENT) return List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));
    else if (this.role == roles.TEACHER) return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"));
    else if(this.role == roles.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
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
