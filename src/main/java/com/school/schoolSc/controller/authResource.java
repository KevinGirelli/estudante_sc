package com.school.schoolSc.controller;

import com.school.schoolSc.Entity.dto.loginDTO;
import com.school.schoolSc.Entity.schools;
import com.school.schoolSc.Entity.student;
import com.school.schoolSc.Entity.teacher;
import com.school.schoolSc.services.TokenService;
import com.school.schoolSc.repository.schoolRepository;
import com.school.schoolSc.repository.studentRepository;
import com.school.schoolSc.repository.teacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class authResource {
  @Autowired
  studentRepository studentRepository;

  @Autowired
  teacherRepository teacherRepository;

  @Autowired
  schoolRepository schoolRepository;

  @Autowired
  TokenService tokenService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @PostMapping("/login-submit")
  public ResponseEntity loginSubmit(loginDTO data){
    student studentLogin = this.studentRepository.findByEmail(data.email());
    teacher teacherLogin = this.teacherRepository.findByEmail(data.email());
    schools schoolLogin = this.schoolRepository.findByEmail(data.email());

    if(studentLogin != null){
      if(passwordEncoder.matches(studentLogin.getPassword(), data.password()) == true) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(studentLogin.getUsername(), studentLogin.getPassword(), studentLogin.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenService.GenerateToken(studentLogin);
        return ResponseEntity.ok().body(token);
      }
    }

    if(teacherLogin != null){
      if(passwordEncoder.matches(teacherLogin.getPassword(), data.password()) == true){
        Authentication authentication = new UsernamePasswordAuthenticationToken(teacherLogin.getUsername(),teacherLogin.getPassword(),teacherLogin.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenService.GenerateToken(teacherLogin);
        return ResponseEntity.ok().body(token);
      }
    }

    if(schoolLogin != null){
      if(passwordEncoder.matches(schoolLogin.getPassword(),data.password()) == true){
        Authentication authentication = new UsernamePasswordAuthenticationToken(schoolLogin.getUsername(),schoolLogin.getPassword(),schoolLogin.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenService.GenerateToken(schoolLogin);
        return ResponseEntity.ok().body(token);
      }
    }
    return ResponseEntity.badRequest().body("Login not found, check your credentials");
  }
}
