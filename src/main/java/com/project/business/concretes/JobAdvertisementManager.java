package com.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.business.abstracts.JobAdvertisementsService;
import com.project.business.concretes.validators.JobAdvertisementValidator;
import com.project.dataAccess.JobAdvertisementsDao;
import com.project.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementsService {

	private JobAdvertisementsDao jobAdvertisementsDao;
	private JobAdvertisementValidator jobAdvertisementValidator;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementsDao jobAdvertisementsDao,
			JobAdvertisementValidator jobAdvertisementValidator) {
		super();
		this.jobAdvertisementsDao = jobAdvertisementsDao;
		this.jobAdvertisementValidator = jobAdvertisementValidator;
	}

	@Override
	public void add(JobAdvertisement entity) {
		if (jobAdvertisementValidator.validateJobAdvertisement(entity) == true) {
			System.out.println("Alanlar boş geçilemez");
		} else {
			this.jobAdvertisementsDao.save(entity);
			System.out.println("Yeni iş başarıyla ilanı eklendi");
		}

	}

	@Override
	public void update(JobAdvertisement entity) {
		if (jobAdvertisementValidator.validateJobAdvertisement(entity) == true) {
			System.out.println("Alanlar boş geçilemez");
		} else {
			this.jobAdvertisementsDao.delete(entity);
			this.jobAdvertisementsDao.save(entity);
			System.out.println("Yeni iş başarıyla ilanı güncellendi");
		}

	}

	@Override
	public void delete(JobAdvertisement entity) {
		this.jobAdvertisementsDao.delete(entity);

	}

	@Override
	public List<JobAdvertisement> getByJobName(String jobName) {
		return this.jobAdvertisementsDao.getByJobName(jobName);
	}

	@Override
	public List<JobAdvertisement> getByCompanyName(String companyName) {
		return this.jobAdvertisementsDao.getByCompanyName(companyName);
	}

	@Override
	public List<JobAdvertisement> getByActive(boolean active) {
		return this.jobAdvertisementsDao.getByActive(active);
	}

	@Override
	public List<JobAdvertisement> getByEarlyDate() {
		return this.jobAdvertisementsDao.getByEarlyDate();
	}

	@Override
	public List<JobAdvertisement> getByLastDate() {
		return this.jobAdvertisementsDao.getByLastDate();
	}

	@Override
	public List<JobAdvertisement> getAll() {
		return this.jobAdvertisementsDao.findAll();
	}

}
