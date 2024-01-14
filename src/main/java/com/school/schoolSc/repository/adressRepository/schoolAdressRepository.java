package com.school.schoolSc.repository.adressRepository;

import com.school.schoolSc.Entity.adresses.schoolAdress;
import com.school.schoolSc.Entity.schools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface schoolAdressRepository extends JpaRepository<schoolAdress,Long> { }
