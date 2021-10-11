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

import com.project.business.concretes.JobSeekerManager;
import com.project.business.concretes.ResumeManager;
import com.project.entities.concretes.JobSeeker;
import com.project.entities.concretes.Resume;

@RestController
@RequestMapping(value = "/hrms")
public class HrmsResumeController {

	// TODO 1 ***Person ve onu extend eden entitylerin postgrede farklı tablolarda
	// gelmeme nedenini hocaya sor

	@Autowired
	ResumeManager resumeManager;
	
	
	@GetMapping(value = "/listofresume")
	public List<Resume> listOfAllResume() {
		return resumeManager.getAll();
	}
	
	//Bir adaya ait cv'yi görüntüleme
	@GetMapping(value = "/getresumebyjobseekerid/{id}")
	public Resume getResumeByJobSeekerId(@PathVariable String id) {
		return resumeManager.getResumeByJobSeekerId(Long.valueOf(id));
	}
	
	@PostMapping(value = "/addresume")
	public ResponseEntity<Resume> addResume(@RequestBody Resume resume) {
		resumeManager.add(resume);
		return new ResponseEntity<>(resume, HttpStatus.CREATED);
	};
	


}
