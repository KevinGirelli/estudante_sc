package com.school.schoolSc.services;

import com.auth0.jwt.algorithms.Algorithm;
import com.school.schoolSc.Entity.schools;
import com.school.schoolSc.Entity.student;
import com.school.schoolSc.Entity.teacher;
import com.school.schoolSc.repository.studentRepository;
import com.school.schoolSc.repository.teacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

  @Autowired
  studentRepository studentRepository;

  @Autowired
  teacherRepository teacherRepository;

  @Value("${api.security.token.secret}")
  private String secret;

  public String GenerateToken(student student){
    Algorithm algorithm = Algorithm.HMAC256(secret);
    String token = JWT.create()
            .withIssuer("estudanteSC")
            .withSubject(student.getUsername())
            .withExpiresAt(genExpirationDate())
            .sign(algorithm);
    return token;
  }

  public String GenerateToken(teacher teacher){
    Algorithm algorithm = Algorithm.HMAC256(secret);
    String token = JWT.create()
            .withIssuer("estudanteSC")
            .withSubject(teacher.getUsername())
            .withExpiresAt(genExpirationDate())
            .sign(algorithm);
    return token;
  }

  public String GenerateToken(schools school){
    Algorithm algorithm = Algorithm.HMAC256(secret);
    String token = JWT.create()
            .withIssuer("estudanteSC")
            .withSubject(school.getUsername())
            .withExpiresAt(genExpirationDate())
            .sign(algorithm);
    return token;
  }

  public String validateToken(String token){
    Algorithm algorithm = Algorithm.HMAC256(secret);
    try {
      return JWT.require(algorithm)
              .withIssuer("estudanteSC")
              .build()
              .verify(token)
              .getSubject();
    }catch (Exception erro){
      return "";
    }

  }

  private Instant genExpirationDate(){
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    // now() = tempo atual, plusHours(2) = adicione 2 horas no tempo atual, toInstant() = fuzo horario
    // tradução: pegue o tempo atual, e adicione 2 horas, ou seja, após duas horas o token expira.
  }
}
