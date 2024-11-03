 package com.onefactor.employer.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

 
@Data
@Entity
@Table(name = "employer")
public class Employer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String profileImageSrc;
    
    private String companyTagline;
    
    private int companyFounded;
    
    private String companyName;
    
    private String employeeCount;
    @Column(length=100000)
    private String note;
    
    private String resourceUri;
    
    private List<Long> jobId;
   
   
}
