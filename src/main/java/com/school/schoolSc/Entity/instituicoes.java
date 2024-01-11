package com.school.schoolSc.Entity;

import com.school.schoolSc.Entity.adresses.studentAdress;
import jakarta.persistence.*;

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
    studentAdress adress;

    @Column(name = "StudentAmount",nullable = false)
    int studentAmount;

    @Column(name = "TeacherAmount",nullable = false)
    int teacherAmount;


}
