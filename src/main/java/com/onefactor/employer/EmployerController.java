package com.onefactor.employer;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onefactor.employer.entity.Employer;
import com.onefactor.employer.service.EmployerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employer")
public class EmployerController {

    private final EmployerService service;

    public EmployerController(EmployerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {
        Employer savedEmployer = service.save(employer);
        return ResponseEntity.ok(savedEmployer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employer> getEmployer(@PathVariable Long id) {
        Employer employer = service.findById(id);
        return ResponseEntity.ok(employer);
    }

    @GetMapping
    public ResponseEntity<List<Employer>> getAllEmployers() {
        List<Employer> employers = service.findAll();
        return ResponseEntity.ok(employers);
    }
}
