package com.school.schoolSc.Entity;

import jakarta.persistence.*;

@Entity
public class admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column
  String login;

  @Column
  String password;
}
