package com.school.schoolSc.repository;

import com.school.schoolSc.Entity.teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


public interface teacherRepository extends JpaRepository<teacher,Long> {
  teacher findByEmail(String login);
}
