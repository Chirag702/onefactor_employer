package com.onefactor.employer.service;

import java.util.List;

import com.onefactor.employer.entity.Employer;

public interface EmployerService {
	Employer save(Employer employer);

	Employer findById(Long id);

	List<Employer> findAll();
}
