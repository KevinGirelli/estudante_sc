package com.school.schoolSc.Entity;

import jakarta.persistence.*;

@Entity
public class activeCodes {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  public Long getId() {
    return id;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  @Column(nullable = false, unique = true)
  int code;
}
