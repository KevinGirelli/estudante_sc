package com.school.schoolSc.Entity;

<<<<<<< HEAD
=======
import com.school.schoolSc.Entity.adresses.studentAdress;
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class schools implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long schoolID;

    @Column(nullable = false)
    String schoolName;

    @Column(nullable = false)
<<<<<<< HEAD
    String email;

    @Column(nullable = false)
    String password;
=======
    String schoolEmail;

    @Column(nullable = false)
    String schoolPassword;
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be

    @Column(name = "phoneNumber",nullable = false)
    String phoneNumber;

    @Column(name = "directorsName", nullable = false)
    String directorsName;

    @Column(name = "directorsCPF", nullable = false)
    String directorsCPF;

    @Column(name = "directorsPhoneNumber", nullable = false)
    String directorsPhoneNumber;

    @Column
    roles role;

    public Long getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(Long schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolEmail() {
<<<<<<< HEAD
        return email;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.email = schoolEmail;
    }

    public String getSchoolPassword() {
        return password;
    }

    public void setSchoolPassword(String schoolPassword) {
        this.password = schoolPassword;
=======
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getSchoolPassword() {
        return schoolPassword;
    }

    public void setSchoolPassword(String schoolPassword) {
        this.schoolPassword = schoolPassword;
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getDirectorsCPF() {
        return directorsCPF;
    }

    public void setDirectorsCPF(String directorsCPF) {
        this.directorsCPF = directorsCPF;
    }

    public String getDirectorsPhoneNumber() {
        return directorsPhoneNumber;
    }

    public void setDirectorsPhoneNumber(String directorsPhoneNumber) {
        this.directorsPhoneNumber = directorsPhoneNumber;
    }

    public roles getRole() {
        return role;
    }

    public void setRole(roles role) {
        this.role = role;
    }

<<<<<<< HEAD
=======
    public studentAdress getAdress() {
        return adress;
    }

    public void setAdress(studentAdress adress) {
        this.adress = adress;
    }

>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
    public int getStudentAmount() {
        return studentAmount;
    }

    public void setStudentAmount(int studentAmount) {
        this.studentAmount = studentAmount;
    }

    public int getTeacherAmount() {
        return teacherAmount;
    }

    public void setTeacherAmount(int teacherAmount) {
        this.teacherAmount = teacherAmount;
    }

<<<<<<< HEAD
=======
    @ManyToOne
    studentAdress adress;

>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
    @Column(name = "StudentAmount",nullable = false)
    int studentAmount;

    @Column(name = "TeacherAmount",nullable = false)
    int teacherAmount;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == roles.SCHOOL_ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_SCHOOLADMIN"));
        else{
            return null;
        }
    }

    @Override
    public String getPassword() {
<<<<<<< HEAD
        return password;
=======
        return schoolPassword;
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
    }

    @Override
    public String getUsername() {
<<<<<<< HEAD
        return email;
=======
        return schoolEmail;
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
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
