package com.school.schoolSc.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class schoolRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne
  schools schools;

  @Column
  Date requestDate;

  public Long getId() {
    return id;
  }

  public com.school.schoolSc.Entity.schools getSchools() {
    return schools;
  }

  public void setSchools(com.school.schoolSc.Entity.schools schools) {
    this.schools = schools;
  }

  public Date getRequestDate() {
    return requestDate;
  }

  public void setRequestDate(Date requestDate) {
    this.requestDate = requestDate;
  }
}
