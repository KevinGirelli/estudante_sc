package com.school.schoolSc.infra.security;

import com.school.schoolSc.repository.schoolRepository;
import com.school.schoolSc.repository.studentRepository;
import com.school.schoolSc.repository.teacherRepository;
import com.school.schoolSc.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class securityFilter extends OncePerRequestFilter {
  @Autowired
  private TokenService tokenService;

  @Autowired
  studentRepository studentRepository;

  @Autowired
  teacherRepository teacherRepository;

  @Autowired
  schoolRepository schoolRepository;


  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      var token = this.recoverToken(request);

      if(token != null){
        var validate = tokenService.validateToken(token);

        UserDetails newStudent = studentRepository.findByEmail(validate);
        UserDetails newTeacher = teacherRepository.findByEmail(validate);
        UserDetails newSchool = schoolRepository.findByEmail(validate);

        if(newStudent != null){
          Authentication authentication = new UsernamePasswordAuthenticationToken(newStudent,null, newStudent.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        if(newTeacher != null){
            Authentication authentication = new UsernamePasswordAuthenticationToken(newTeacher,null,newTeacher.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
      }

      }
    filterChain.doFilter(request,response);
  }

  private String recoverToken(HttpServletRequest request){
      var authHeader = request.getHeader("Authorization");

      if(authHeader == null) return null;
      return authHeader.replace("Bearer ","");
      // precisa desse espaço no Bearer
  }
}
