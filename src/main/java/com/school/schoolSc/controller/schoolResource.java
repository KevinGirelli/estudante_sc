package com.school.schoolSc.controller;

import com.school.schoolSc.Entity.schoolRequest;
import com.school.schoolSc.Entity.schools;
import com.school.schoolSc.repository.schoolRequestRepository;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/school")
public class schoolResource {

  @Autowired
  schoolRepository schoolRepository;

  @Autowired
  schoolRequestRepository schoolRequestRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  TokenService tokenService;

  @PostMapping("/register-submit")
  public ResponseEntity registerSchool(@RequestBody schools newSchool){
    schoolRepository.save(newSchool);

    schoolRequest SchoolRequest = new schoolRequest();
    SchoolRequest.setSchools(newSchool);
    SchoolRequest.setRequestDate(Date.from(Instant.now()));
    this.schoolRequestRepository.save(SchoolRequest);
    return ResponseEntity.ok().build();
  }

}
