package com.school.schoolSc.Entity;

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
    String email;

    @Column(nullable = false)
    String password;

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
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
