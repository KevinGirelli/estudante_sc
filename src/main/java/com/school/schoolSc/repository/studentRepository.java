package com.school.schoolSc.repository;

import com.school.schoolSc.Entity.student;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

public interface studentRepository extends JpaRepository<student,Long> {
  student findByEmail(String login);
}
