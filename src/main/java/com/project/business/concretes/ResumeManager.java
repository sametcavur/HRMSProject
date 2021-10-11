package com.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.business.abstracts.ResumeService;
import com.project.dataAccess.JobSeekerDao;
import com.project.dataAccess.ResumeDao;
import com.project.entities.concretes.JobSeeker;
import com.project.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{
	
	private ResumeDao resumeDao;
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, JobSeekerDao jobSeekerDao) {
		super();
		this.resumeDao = resumeDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public void add(Resume entity) {
		resumeDao.save(entity);
		
	}


	@Override
	public void update(Resume entity) {
		resumeDao.deleteById(entity.getId());
		resumeDao.save(entity);
		
	}

	@Override
	public void delete(Resume entity) {
		resumeDao.delete(entity);
		
	}

	@Override
	public List<Resume> getAll() {
		// TODO Auto-generated method stub
		return resumeDao.findAll();
	}

	@Override
	public Resume getResumeByJobSeekerId(long id) {
		JobSeeker jobSeeker = jobSeekerDao.getById(id);
		return jobSeeker.getResume();
	}
	

}
