package com.school.schoolSc.controller;

<<<<<<< HEAD
import com.school.schoolSc.Entity.dto.studentLoginDTO;
import com.school.schoolSc.Entity.student;
import com.school.schoolSc.infra.security.TokenService;
=======
import com.school.schoolSc.Entity.adresses.studentAdress;
import com.school.schoolSc.Entity.dto.studentLoginDTO;
import com.school.schoolSc.Entity.student;
import com.school.schoolSc.infra.security.TokenService;
import com.school.schoolSc.repository.adressRepository.StudentAdressRepository;
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
import com.school.schoolSc.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
<<<<<<< HEAD
@CrossOrigin
=======
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be
@RequestMapping("/student")
public class studentResource {

  @Autowired
  TokenService tokenService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  studentRepository studentRepository;

<<<<<<< HEAD
=======
  @Autowired
  StudentAdressRepository adressRepository;
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be

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
<<<<<<< HEAD
  public ResponseEntity registerSubmit (@RequestBody student data){
    //insert do usuario
    data.setPassword(passwordEncoder.encode(data.getPassword()));
    studentRepository.save(data);
=======
  public ResponseEntity registerSubmit (@RequestBody studentAdress data){
    //insert do usuario
    student newStudent = data.getStudent();
    newStudent.setPassword(passwordEncoder.encode(newStudent.getPassword()));
    studentRepository.save(newStudent);

    //insert do endereço
    data.setStudent(studentRepository.findByEmail(newStudent.getUsername()));
    adressRepository.save(data);
>>>>>>> 5bba13220c6deae1b38058f25b7fa76a121763be

    return ResponseEntity.ok().build();

  }

  @PostMapping("/login-submit")
  public ResponseEntity<String> loginSubmit(@RequestBody studentLoginDTO data){
    student userToLogin = studentRepository.findByEmail(data.email());
    if(userToLogin != null){
      Authentication authentication = new UsernamePasswordAuthenticationToken(userToLogin.getUsername(),userToLogin.getPassword(),userToLogin.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);

      String token = tokenService.GenerateToken(userToLogin);
      return ResponseEntity.ok().body(token);
    }else{
      return ResponseEntity.badRequest().body("student not found or credentials invalid");
    }

  }
}
