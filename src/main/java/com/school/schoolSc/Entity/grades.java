package com.school.schoolSc.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
public class grades {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long gradeID;

  @Column(name = "gradeValue", nullable = false)
  Float gradeValue;

  @Column(name = "date",nullable = false)
  Date date;

  @ManyToOne
  subjects subject;

  @ManyToOne
  student student;
}
