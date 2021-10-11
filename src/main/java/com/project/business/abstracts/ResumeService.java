package com.project.business.abstracts;

import org.springframework.stereotype.Service;

import com.project.entities.concretes.Resume;

@Service
public interface ResumeService extends EntityRepositoryService<Resume>{
	Resume getResumeByJobSeekerId(long id);
}
