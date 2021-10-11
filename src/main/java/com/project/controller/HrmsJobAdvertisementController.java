package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.business.concretes.JobAdvertisementManager;
import com.project.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping(value = "/hrms")
public class HrmsJobAdvertisementController {

	@Autowired
	JobAdvertisementManager jobAdvertisementService;
	
	@PostMapping(value = "/addjobadvertisement")
	public ResponseEntity<JobAdvertisement> addJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
		jobAdvertisementService.add(jobAdvertisement);
		return new ResponseEntity<>(jobAdvertisement, HttpStatus.CREATED);
	}

	@GetMapping(value = "/listofjobadvertisements")
	public List<JobAdvertisement> listOfAllJobAdvertisements() {
		return jobAdvertisementService.getAll();
	}

	// İşin adına göre listeleme
	@GetMapping(value = "/getbyname/{jobName}")
	public List<JobAdvertisement> getJobAdvertisementByName(@PathVariable String jobName) {
		return jobAdvertisementService.getByJobName(jobName);

	}

	// İş ilanını yayınlayan şirkete göre listeleme
	@GetMapping(value = "/getbycompanyname/{companyName}")
	public List<JobAdvertisement> getJobAdvertisementByCompanyName(@PathVariable String companyName) {
		return jobAdvertisementService.getByCompanyName(companyName);
	}

	// İşin aktifliğine göre listeleme
	@GetMapping(value = "/getbyactive/{active}")
	public List<JobAdvertisement> getJobAdvertisementByActive(@PathVariable String active) {
		boolean convertStringtoBoolean = Boolean.parseBoolean(active);
		return jobAdvertisementService.getByActive(convertStringtoBoolean);
	}

	// Erken tarihe göre iş ilanlarını listeleme
	@GetMapping(value = "/getbyearlydate")
	public List<JobAdvertisement> getJobAdvertisementByEarlyDate() {
		return jobAdvertisementService.getByEarlyDate();
	}

	// Geç tarihe göre iş ilanlarını listeleme
	@GetMapping(value = "/getbylastdate")
	public List<JobAdvertisement> getJobAdvertisementLastByDate() {
		return jobAdvertisementService.getByLastDate();
	}
	
	
	
	
	
	/********************************************************************

	// İsme göre aranılan iş ilanını getirme
	@GetMapping(value = "/getadvertisementbyname/{jobAdvertisement}")
	public JobAdvertisement getJobAdvertisementByName(@PathVariable("jobAdvertisement") String jobAdvertisement) {
		for (JobAdvertisement jobs : jobAdvertisementService.getAll()) {
			if (jobs.getName().equals(jobAdvertisement)) {
				return jobs;
			}
		}
		return null;  // TODO 4 404 atmayı araştır.!
	}

	// Şehire göre aranılan iş ilanını getirme
	@GetMapping(value = "/getadvertisementbycity/{city}")
	public JobAdvertisement getJobAdvertisementByCity(@PathVariable(value = "city") String city) {
		for (JobAdvertisement jobs : jobAdvertisementService.getAll()) {
			if (jobs.getCity().equals(city)) {
				return jobs;
			}
		}
		return null; // TODO 4 404 atmayı araştır.!
	}

	// Şirkete göre aranılan iş ilanını getirme
	@GetMapping(value = "/getadvertisementbycompany/{company}")
	public JobAdvertisement getJobAdvertisementByCompany(@PathVariable(value = "company") String company) {
		for (JobAdvertisement jobs : jobAdvertisementService.getAll()) {
			if (jobs.getCompanyName().equals(company)) {
				return jobs;
			}
		}
		return null; // TODO 4 404 atmayı araştır.!
	}
		 ********************************************************************/


}
