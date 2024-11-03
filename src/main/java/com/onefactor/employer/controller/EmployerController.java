package com.onefactor.employer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onefactor.employer.client.AuthClient;
import com.onefactor.employer.entity.Employer;
import com.onefactor.employer.service.EmployerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employer")
public class EmployerController {

	
	@Autowired
	AuthClient authClient;
    private final EmployerService service;

    public EmployerController(EmployerService service) {
        this.service = service;
    }

    
	private boolean isUserAuthorized(String authHeader) {
		String validationResponse = authClient.validateUser(authHeader);
		return validationResponse != null;
	}

	private String extractJwtToken(String token) {
		if (token == null || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7); // Remove "Bearer " prefix
	}

    @PostMapping
    public ResponseEntity<?> createEmployer(@RequestBody Employer employer,@RequestHeader("Authorization") String authorization) {

		if (!isUserAuthorized(extractJwtToken(authorization))) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
		}


        Employer savedEmployer = service.save(employer);
        return ResponseEntity.ok(savedEmployer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployer(@PathVariable Long id,@RequestHeader("Authorization") String authorization) {

		if (!isUserAuthorized(extractJwtToken(authorization))) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
		}


        Employer employer = service.findById(id);
        return ResponseEntity.ok(employer);
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployers(@RequestHeader("Authorization") String authorization) {

		if (!isUserAuthorized(extractJwtToken(authorization))) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
		}


        List<Employer> employers = service.findAll();
        return ResponseEntity.ok(employers);
    }
}
