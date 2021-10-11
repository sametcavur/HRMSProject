package com.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.adapter.MernisAdapter;
import com.project.business.abstracts.PersonalService;
import com.project.business.concretes.validators.PersonalValidator;
import com.project.dataAccess.PersonalDao;
import com.project.entities.concretes.Personal;

@Service
public class PersonalManager implements PersonalService {
	private MernisAdapter mernisAdapter;
	private PersonalValidator personalValidator;
	private PersonalDao personalDao;
	

	@Autowired
	public PersonalManager(MernisAdapter mernisAdapter, PersonalDao personalDao, PersonalValidator personalValidator) {
		super();
		this.mernisAdapter = mernisAdapter;
		this.personalDao = personalDao;
		this.personalValidator = personalValidator;
	}

	@Override
	public void add(Personal entity) {
		if (mernisAdapter.validate(entity) == true) {
			System.out.println("Personal Mernis ile doğrulanamadı");
		} else if (personalValidator.checkEmailFromDatabase(entity) == true) {
			System.out.println("Alanlar boş geçilemez");
		} else if (personalValidator.checkEmailFromDatabase(entity) == true) {
			System.out.println("Daha önce kayıtlı email,lütfen başka bir email giriniz");
		} else {
			this.personalDao.save(entity);
			System.out.println("Personal başarıyla kaydoldu");
		}

	}

	@Override
	public void update(Personal entity) {
		if (mernisAdapter.validate(entity) == true) {
			System.out.println("Personal Mernis ile doğrulanamadı");
		} else if (personalValidator.checkEmailFromDatabase(entity) == true) {
			System.out.println("Alanlar boş geçilemez");
		} else if (personalValidator.checkEmailFromDatabase(entity) == true) {
			System.out.println("Daha önce kayıtlı email,lütfen başka bir email giriniz");
		} else {
			this.personalDao.delete(entity);
			this.personalDao.save(entity);
			System.out.println("Personal başarıyla güncellendi");
		}

	}

	@Override
	public void delete(Personal entity) {
		this.personalDao.delete(entity);
		System.out.println("Employer başarıyla silindi");

	}

	@Override
	public List<Personal> getAll() {
		return personalDao.findAll();
	}

}
