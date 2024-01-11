package com.school.schoolSc.repository;

import com.school.schoolSc.Entity.adminManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface adminRepository extends JpaRepository<adminManagement, Long> {
  UserDetails findBylogin(String login);
}
