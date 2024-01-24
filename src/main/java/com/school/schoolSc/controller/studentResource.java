package com.school.schoolSc.controller;

import com.school.schoolSc.Entity.roles;
import com.school.schoolSc.Entity.student;
import com.school.schoolSc.services.EmailService;
import com.school.schoolSc.services.TokenService;
import com.school.schoolSc.repository.studentRepository;
import com.school.schoolSc.services.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@CrossOrigin
@RequestMapping("/student")
public class studentResource {

  @Autowired
  TokenService tokenService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  studentRepository studentRepository;

  @Autowired
  EmailServiceImpl emailService;


  //pra retornar as paginas html pro cliente precisa fazer uma função do
  //tipo ModelAndView e instanciar um objeto dessa classe e passar o nome do arquivo html
  //os arquivos html tem q ser guardados em resources/templates
  //lembrando que a classe resource tem que usar a anotação @Controller e não @RestController
  @GetMapping("/studentHome")
  public ModelAndView register (){
    ModelAndView mv = new ModelAndView("home");
    return mv;
  }

  @PostMapping("/register-submit")
  public ResponseEntity registerSubmit (@RequestBody student data){
    //insert do usuario
    data.setPassword(passwordEncoder.encode(data.getPassword()));
    data.setRole(roles.STUDENT);
    studentRepository.save(data);
    //fazer email de confirmação
    return ResponseEntity.ok().build();
  }
}
