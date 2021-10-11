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

import com.project.business.concretes.PersonalManager;
import com.project.entities.concretes.Personal;

@RestController
@RequestMapping(value = "/hrms")
public class HrmsPersonalController {
	
	@Autowired
	PersonalManager personalService;
	
	@GetMapping(value = "/listofpersonal")
	public List<Personal> listOfAllPersonals() {
		return personalService.getAll();
	}
	
	@PostMapping(value = "/addpersonal")
	public ResponseEntity<Personal> addPersonal(@RequestBody Personal personal) {
		personalService.add(personal);
		return new ResponseEntity<>(personal, HttpStatus.CREATED);
	}

}
