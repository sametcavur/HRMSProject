package com.project.business.concretes.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dataAccess.JobSeekerDao;
import com.project.entities.concretes.JobSeeker;

@Service
public class JobSeekerValidator {
	
	
	@Autowired
	private JobSeekerDao jobSeekerDao;
	
	public boolean validateJobSeeker(JobSeeker entity) {
		if (validateName(entity) == true || 
				validateLastName(entity) == true || 
				validateNationalIdentityNumber(entity) == true || 
				validateEmail(entity) == true || 
				validateTitle(entity) == true || 
				validatePassword(entity) == true || 
				validateAge(entity) == true) {
			return true;
		}else {
			return false;
		}
	}
	

	public boolean validateName(JobSeeker jobSeeker) {
		if (jobSeeker.getName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateLastName(JobSeeker jobSeeker) {
		if (jobSeeker.getLastName().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateAge(JobSeeker jobSeeker) {
		if (jobSeeker.getAge() < 18) {
			return true;
		}
		return false;
	}

	public boolean validateEmail(JobSeeker jobSeeker) {
		if (jobSeeker.getEmail().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateNationalIdentityNumber(JobSeeker jobSeeker) {
		if (jobSeeker.getNationalIdentityNumber().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validatePassword(JobSeeker jobSeeker) {
		if (jobSeeker.getPassword().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean validateTitle(JobSeeker jobSeeker) {
		if (jobSeeker.getTitle().isBlank()) {
			return true;
		}
		return false;
	}

	public boolean checkEmailFromDatabase(JobSeeker jobSeeker) {
		List<JobSeeker> jobSeekers = this.jobSeekerDao.findAll();
		for (JobSeeker jobS : jobSeekers) {
			if (jobSeeker.getEmail() == jobS.getEmail()) {
				return true;
			}
		}
		return false;
	}

}
