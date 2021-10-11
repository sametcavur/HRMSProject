package com.project.business.concretes.validators;

import org.springframework.stereotype.Service;

import com.project.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementValidator {
	
	
	public boolean validateJobAdvertisement(JobAdvertisement entity) {
		if (validateName(entity) == true || 
				validateCity(entity) == true || 
				validateDescription(entity) == true || 
				validateMaxSalary(entity) == true || 
				validateMinSalary(entity) == true || 
				validateName(entity) == true || 
				validateCompanyName(entity) == true|| 
				validateCount(entity) == true) {
			return true;
		}else {
			return false;
		}
	}
	public boolean validateCity(JobAdvertisement entity) {
		if (entity.getCity().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateDescription(JobAdvertisement entity) {
		if (entity.getDescription().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateMinSalary(JobAdvertisement entity) {
		if (entity.getMinSalary() <= 0) {
			return true;
		}
		return false;
	}

	public boolean validateMaxSalary(JobAdvertisement entity) {
		if (entity.getMaxSalary() <= entity.getMinSalary()) {
			return true;
		}
		return false;
	}

	public boolean validateName(JobAdvertisement entity) {
		if (entity.getjobName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateCompanyName(JobAdvertisement entity) {
		if (entity.getCompanyName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateCount(JobAdvertisement entity) {
		if (entity.getNumberOfPersonnelSought() <= 0) {
			return true;
		}
		return false;
	}

}
