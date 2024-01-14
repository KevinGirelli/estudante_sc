package com.school.schoolSc.repository.adressRepository;

import com.school.schoolSc.Entity.adresses.studentAdress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAdressRepository extends JpaRepository<studentAdress,Long> { }
