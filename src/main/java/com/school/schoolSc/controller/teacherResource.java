package com.school.schoolSc.controller;


import com.school.schoolSc.Entity.teacher;
import com.school.schoolSc.services.TokenService;
import com.school.schoolSc.repository.teacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class teacherResource {

  @Autowired
  teacherRepository teacherRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  TokenService tokenService;

  @PostMapping("/register-submit")
  public ResponseEntity teacherRegister(@RequestBody teacher data){
    //insert do professor
      data.setPassword(passwordEncoder.encode(data.getPassword()));
      this.teacherRepository.save(data);
      return ResponseEntity.ok().build();
  }
}
