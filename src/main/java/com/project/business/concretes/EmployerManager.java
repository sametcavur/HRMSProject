package com.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.adapter.MernisAdapter;
import com.project.business.abstracts.EmployerService;
import com.project.business.concretes.validators.EmployerValidator;
import com.project.dataAccess.EmployerDao;
import com.project.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerValidator employerValidator;
	private MernisAdapter mernisAdapter;
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerValidator employerValidator, MernisAdapter mernisAdapter, EmployerDao employerDao) {
		super();
		this.employerValidator = employerValidator;
		this.mernisAdapter = mernisAdapter;
		this.employerDao = employerDao;
	}

	@Override
	public void add(Employer entity) {
		if (mernisAdapter.validate(entity)==true) {
			System.out.println("Employer Mernis ile doğrulanamadı");
		} else if (employerValidator.validateEmployer(entity) == true) {
			System.out.println("Alanlar boş geçilemez");
		} else if (employerValidator.checkEmailFromDatabase(entity) == true) {
			System.out.println("Daha önce kayıtlı email,lütfen başka bir email giriniz");
		} else {
			this.employerDao.save(entity);
			System.out.println("Employer başarıyla kaydoldu");
		}

	}

	@Override
	public void update(Employer entity) {
		if (mernisAdapter.validate(entity) == true) {
			System.out.println("Employer Mernis ile doğrulanamadı");
		} else if (employerValidator.validateEmployer(entity) == true) {
			System.out.println("Alanlar boş geçilemez");
		} else if (employerValidator.checkEmailFromDatabase(entity) == true) {
			System.out.println("Daha önce kayıtlı email,lütfen başka bir email giriniz");
		} else {
			this.employerDao.delete(entity);
			this.employerDao.save(entity);
			System.out.println("Employer başarıyla güncellendi");
		}

	}

	@Override
	public void delete(Employer entity) {
		this.employerDao.delete(entity);
		System.out.println("Employer başarıyla silindi");

	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

}
