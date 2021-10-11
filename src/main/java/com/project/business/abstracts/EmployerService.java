package com.project.business.abstracts;

import org.springframework.stereotype.Service;

import com.project.entities.concretes.Employer;

@Service
public interface EmployerService extends EntityRepositoryService<Employer> {

}
