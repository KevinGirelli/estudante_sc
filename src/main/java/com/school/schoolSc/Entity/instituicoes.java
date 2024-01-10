package com.school.schoolSc.Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class instituicoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long instituicaoID;

    @Column(nullable = false)
    String insistuicaoName;

    @Column(nullable = false)
    String instituicaoEmail;

    @Column(nullable = false)
    String instituicaoPassword;

    @Column(name = "phoneNumber",nullable = false)
    String phoneNumber;
    @ManyToOne
    adress adress;

    @Column(name = "StudentAmount",nullable = false)
    int studentAmount;

    @Column(name = "TeacherAmount",nullable = false)
    int teacherAmount;


}
