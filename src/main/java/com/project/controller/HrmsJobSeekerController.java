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

import com.project.business.concretes.JobSeekerManager;
import com.project.entities.concretes.JobSeeker;

@RestController
@RequestMapping(value = "/hrms")
public class HrmsJobSeekerController {
	

	@Autowired
	JobSeekerManager jobSeekerService;

	
	@GetMapping(value = "/listofjobseeker")
	public List<JobSeeker> listOfAllJobSeekers() {
		return jobSeekerService.getAll();
	}
	

	@PostMapping(value = "/addjobseeker")
	public ResponseEntity<JobSeeker> addJobSeeker(@RequestBody JobSeeker jobSeeker) {
		jobSeekerService.add(jobSeeker);
		return new ResponseEntity<>(jobSeeker, HttpStatus.CREATED);
	}
}
