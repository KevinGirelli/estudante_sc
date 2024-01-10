package com.school.schoolSc.Entity;

import jakarta.persistence.*;

@Entity
public class Classroom {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long classID;

  @Column(name = "classNumber",nullable = false)
  String classNumber;

  @Column(name = "students",nullable = false)
  student student;
}
