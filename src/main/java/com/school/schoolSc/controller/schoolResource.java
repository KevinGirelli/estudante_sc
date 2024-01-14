package com.school.schoolSc.controller;

import com.school.schoolSc.Entity.adresses.schoolAdress;
import com.school.schoolSc.Entity.dto.schoolLoginDTO;
import com.school.schoolSc.Entity.schools;
import com.school.schoolSc.infra.security.TokenService;
import com.school.schoolSc.repository.adressRepository.schoolAdressRepository;
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
  schoolAdressRepository schoolAdressRepository;

  @Autowired
  schoolRepository schoolRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  TokenService tokenService;

  @PostMapping("/register-submit")
  public ResponseEntity registerSchool(schoolAdress newSchool){
    schools school = newSchool.getSchool();
    school.setSchoolPassword(passwordEncoder.encode(school.getPassword()));
    this.schoolRepository.save(school);

    newSchool.setSchool(this.schoolRepository.findByEmail(school.getUsername()));
    this.schoolAdressRepository.save(newSchool);

    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity loginSchool(schoolLoginDTO schoolData){
    schools schoolToLogin = this.schoolRepository.findByEmail(schoolData.email());
    if(schoolToLogin != null){
      if(passwordEncoder.matches(schoolData.password(),schoolToLogin.getPassword())){
        Authentication authentication = new UsernamePasswordAuthenticationToken(schoolToLogin.getUsername(),schoolToLogin.getPassword(),schoolToLogin.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok().body(tokenService.GenerateToken(schoolToLogin));
      }else{
        return ResponseEntity.badRequest().body("password invalid");
      }
    }else{
      return ResponseEntity.badRequest().body("School not found or credentials invalid");
    }
  }
}
