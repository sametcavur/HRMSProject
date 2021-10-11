package com.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.project.adapter.MernisAdapter;
import com.project.business.abstracts.JobSeekerService;
import com.project.business.concretes.validators.JobSeekerValidator;
import com.project.dataAccess.JobSeekerDao;
import com.project.entities.concretes.JobSeeker;

@Service
@Configuration
public class JobSeekerManager implements JobSeekerService {
	private MernisAdapter mernisAdapter;
	private JobSeekerValidator jobSeekerValidator;
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(MernisAdapter mernisAdapter, JobSeekerValidator jobSeekerValidator,
			JobSeekerDao jobSeekerDao) {
		super();
		this.mernisAdapter = mernisAdapter;
		this.jobSeekerValidator = jobSeekerValidator;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public void add(JobSeeker entity) {
		if (mernisAdapter.validate(entity) == true) {
			System.out.println("Job Seeker Mernis ile doğrulanamadı");
		} else if (jobSeekerValidator.validateJobSeeker(entity) == true) {
			System.out.println("Alanlar boş geçilemez");
		} else if (jobSeekerValidator.checkEmailFromDatabase(entity) == true) {
			System.out.println("Daha önce kayıtlı email,lütfen başka bir email giriniz");
		} else {
			jobSeekerDao.save(entity);
			System.out.println("Job Seeker başarıyla kaydoldu");
		}

	}

	@Override
	public void update(JobSeeker entity) {
		if (mernisAdapter.validate(entity) == true) {
			System.out.println("Job Seeker Mernis ile doğrulanamadı");
		} else if (jobSeekerValidator.validateJobSeeker(entity) == true) {
			System.out.println("Alanlar boş geçilemez");
		} else if (jobSeekerValidator.checkEmailFromDatabase(entity) == true) {
			System.out.println("Daha önce kayıtlı email,lütfen başka bir email giriniz");
		} else {
			jobSeekerDao.delete(entity);
			jobSeekerDao.save(entity);
			System.out.println("Job Seeker başarıyla güncellendi");
		}

	}

	@Override
	public void delete(JobSeeker entity) {
		jobSeekerDao.delete(entity);

	}

	@Override
	public List<JobSeeker> getAll() {
		return jobSeekerDao.findAll();
	}


}
