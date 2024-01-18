package com.school.schoolSc.controller;


import com.school.schoolSc.Entity.dto.teacherLoginDTO;
import com.school.schoolSc.Entity.teacher;
import com.school.schoolSc.infra.security.TokenService;
import com.school.schoolSc.repository.teacherRepository;
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

@Controller
@RequestMapping("/teacher")
public class teacherResource {

  @Autowired
  teacherRepository teacherRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  TokenService tokenService;

  @PostMapping("/login-submit")
  public ResponseEntity teacherLogin(@RequestBody teacherLoginDTO teacherLogin){
      teacher teacherToLogin = this.teacherRepository.findByEmail(teacherLogin.email());
      if(teacherToLogin != null){
        if(passwordEncoder.matches(teacherLogin.password(),teacherToLogin.getPassword()) == true){
            Authentication authentication = new UsernamePasswordAuthenticationToken(teacherToLogin.getUsername(),teacherToLogin.getPassword(),teacherToLogin.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return ResponseEntity.ok().body(tokenService.GenerateToken(teacherToLogin));

        }else{
          return ResponseEntity.badRequest().body("senha invalida");
        }
      }
      return ResponseEntity.internalServerError().build();
  }
  @PostMapping("/register-submit")
  public ResponseEntity teacherRegister(@RequestBody teacher data){
    //insert do professor
      data.setPassword(passwordEncoder.encode(data.getPassword()));
      this.teacherRepository.save(data);
      return ResponseEntity.ok().build();
  }
}
