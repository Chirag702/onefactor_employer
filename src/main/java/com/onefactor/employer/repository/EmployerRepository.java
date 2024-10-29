package com.onefactor.employer.repository;

 
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onefactor.employer.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
