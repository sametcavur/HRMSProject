package com.project.business.abstracts;

import org.springframework.stereotype.Service;

import com.project.entities.abstracts.Person;
@Service
public interface ValidationService {
	boolean validate(Person person);
}
