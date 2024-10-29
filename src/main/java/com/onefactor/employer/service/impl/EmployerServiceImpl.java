package com.onefactor.employer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.onefactor.employer.entity.Employer;
import com.onefactor.employer.repository.EmployerRepository;
import com.onefactor.employer.service.EmployerService;

import java.util.List;

@Slf4j
@Service
public class EmployerServiceImpl implements EmployerService {

	private final EmployerRepository repository;

	public EmployerServiceImpl(EmployerRepository repository) {
		this.repository = repository;
	}

	@Override
	public Employer save(Employer employer) {
		log.info("Saving employer: {}", employer);
		// Clear cache after saving a new employer
		return repository.save(employer);
	}

	@Cacheable(value = "employers", key = "#id")
	@Override
	public Employer findById(Long id) {
		log.info("Fetching employer with id: {}", id);
		return repository.findById(id).orElse(null);
	}

	@Cacheable(value = "employers")
	@Override
	public List<Employer> findAll() {
		log.info("Fetching all employers");
		return repository.findAll();
	}
}
