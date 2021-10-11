package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.business.concretes.EmployerManager;
import com.project.entities.concretes.Employer;

@RestController
@RequestMapping(value = "/hrms")
public class HrmsEmployerController {
	
	@Autowired
	EmployerManager employerService;
	
	@GetMapping(value = "/listofemployer")
	public List<Employer> listOfAllEmployers() {
		/*
		JobAdvertisement jobAdvertisement1 = new JobAdvertisement("Etiya", 3, "SoftwareDeveloper",
				"Gereksinim 1,Gereksinim 2", "İstanbul", 3500, 5500, new Date(2021, 9, 20), true);
		JobAdvertisement jobAdvertisement2 = new JobAdvertisement("Etiya", 5, "HR", "Gereksinim1,İngilizce C+",
				"Ankara", 4000, 5200, new Date(2021, 9, 20), true);
		List<JobAdvertisement> jobAdvertisements = new ArrayList<JobAdvertisement>();
		jobAdvertisements.add(jobAdvertisement1);
		jobAdvertisements.add(jobAdvertisement2);

		Employer employer = new Employer("Samet", "Çavur", 24, "1234", "samet@gmail.com", "samet.net", "1234",
				jobAdvertisements);
		List<Employer> employers = new ArrayList<Employer>();
		employers.add(employer);
		return employers; 
		*/
		return employerService.getAll();
	}
	
	@PostMapping(value = "/addemployer")
	public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer) {
		employerService.add(employer);
		return new ResponseEntity<>(employer, HttpStatus.CREATED);
	};

}
