package com.project.business.concretes.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dataAccess.PersonalDao;
import com.project.entities.concretes.Personal;

@Service
public class PersonalValidator {
	
	
	@Autowired
	private PersonalDao personalDao;
	
	public boolean validatePersonal(Personal entity) {
		if (validateName(entity) == true || 
				validateLastName(entity) == true || 
				validateNationalIdentityNumber(entity) == true || 
				validateEmail(entity) == true || 
				validateDepartment(entity) == true || 
				validateSalary(entity) == true || 
				validateAge(entity) == true) {
			return true;
		}else {
			return false;
		}
	}

	public boolean validateName(Personal entity) {
		if (entity.getName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateLastName(Personal entity) {
		if (entity.getLastName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateAge(Personal entity) {
		if (entity.getAge() < 18) {
			return true;
		}
		return false;
	}

	public boolean validateEmail(Personal entity) {
		if (entity.getEmail().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateNationalIdentityNumber(Personal entity) {
		if (entity.getNationalIdentityNumber().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateDepartment(Personal entity) {
		if (entity.getDepartment().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateSalary(Personal entity) {
		if (entity.getSalary() <= 0) {
			return true;
		}
		return false;
	}

	public boolean checkEmailFromDatabase(Personal personal) {
		List<Personal> personals = this.personalDao.findAll();
		for (Personal pers : personals) {
			if (personal.getEmail() == pers.getEmail()) {
				return true;
			}
		}
		return false;
	}

}
