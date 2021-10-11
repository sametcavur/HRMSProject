package com.project.business.concretes.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dataAccess.EmployerDao;
import com.project.entities.concretes.Employer;

@Service
public class EmployerValidator {
	
	@Autowired
	private EmployerDao employerDao;
	
	public boolean validateEmployer(Employer entity) {
		if(validateName(entity) == true || 
				validateLastName(entity) == true || 
				validateWebSite(entity) == true || 
				validateNationalIdentityNumber(entity) == true || 
				validateEmail(entity) == true || 
				validatePassword(entity) == true || 
				validateAge(entity) == true) {
			return true;
		}else {
			return false;
		}
		
	}
	

	public boolean validateName(Employer employer) {
		if (employer.getName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateLastName(Employer employer) {
		if (employer.getLastName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateAge(Employer employer) {
		if (employer.getAge() < 18) {
			return true;
		}
		return false;
	}

	public boolean validateEmail(Employer employer) {
		if (employer.getEmail().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateNationalIdentityNumber(Employer employer) {
		if (employer.getNationalIdentityNumber().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateWebSite(Employer employer) {
		if (employer.getWebSite().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validatePassword(Employer employer) {
		if (employer.getPassword().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean checkEmailFromDatabase(Employer employer) {
		List<Employer> employers = this.employerDao.findAll();
		for (Employer empl : employers) {
			if (employer.getEmail() == empl.getEmail()) {
				return true;
			}
		}
		return false;
	}



}
