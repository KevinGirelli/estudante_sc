package com.school.schoolSc.repository;

import com.school.schoolSc.Entity.schools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface schoolRepository extends JpaRepository<schools,Long> {
  public schools findByEmail(String email);
}
