package com.school.schoolSc.controller;

import com.school.schoolSc.Entity.schools;
import com.school.schoolSc.services.TokenService;
import com.school.schoolSc.repository.schoolRepository;
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
@RequestMapping("/adm/school")
public class schoolResource {

  @Autowired
  schoolRepository schoolRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  TokenService tokenService;

  @PostMapping("/register-submit")
  public ResponseEntity registerSchool(schools newSchool){
    return ResponseEntity.ok().build();
  }

}
