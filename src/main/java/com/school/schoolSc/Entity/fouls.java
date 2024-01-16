package com.school.schoolSc.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
public class fouls {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long foulID;

  @Column(name = "description",nullable = true)
  String description;

  @Column(name = "foulsAmount",nullable = false)
  int foulsAmount;

  @ManyToOne
  student student;

  @ManyToOne
  subjects subjects;

  @ManyToOne
  teacher teacher;

  @Column(name = "date",nullable = false)
  Date date;
}
