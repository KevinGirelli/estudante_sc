package com.school.schoolSc.services;

import com.school.schoolSc.repository.schoolRepository;
import com.school.schoolSc.repository.studentRepository;
import com.school.schoolSc.repository.teacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class AuthorizationService implements UserDetailsService {

  @Autowired
  studentRepository studentRepository;

  @Autowired
  teacherRepository teacherRepository;

  @Autowired
  schoolRepository schoolRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if(studentRepository.findByEmail(username).getAuthorities() == List.of(new SimpleGrantedAuthority("ROLE_STUDENT"))){
      return studentRepository.findByEmail(username);
    }else if(teacherRepository.findByEmail(username).getAuthorities() == List.of(new SimpleGrantedAuthority("ROLE_TEACHER"))){
      return teacherRepository.findByEmail(username);
    }else if (schoolRepository.findByEmail(username).getAuthorities() == List.of(new SimpleGrantedAuthority("ROLE_SCHOOLADMIN"))){
      return schoolRepository.findByEmail(username);
    }else{
      throw new UsernameNotFoundException("UsernameNotFound");
    }
  }
}
