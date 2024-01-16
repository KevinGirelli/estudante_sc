package com.school.schoolSc.Entity;

import jakarta.persistence.*;

@Entity
public class subjects {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long subjectID;

  @Column(name = "name",nullable = false)
  String subjectName;

  @Column(name = "description",nullable = false)
  String description;

  @ManyToOne
  Classroom classroom;

  @ManyToOne
  teacher teacher;
}
