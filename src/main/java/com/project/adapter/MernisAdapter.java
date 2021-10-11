package com.project.adapter;

import org.springframework.stereotype.Service;

import com.project.business.abstracts.ValidationService;
import com.project.entities.abstracts.Person;

@Service
public class MernisAdapter implements ValidationService {

	private MernisService mernisService = new MernisService();

	@Override
	public boolean validate(Person person) {
		if (mernisService.validate(person) == false) {
			return false;
		}
		return true;
	}

}
