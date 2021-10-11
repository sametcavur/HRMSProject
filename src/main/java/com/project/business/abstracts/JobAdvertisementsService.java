package com.project.business.abstracts;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.entities.concretes.JobAdvertisement;

@Service
public interface JobAdvertisementsService extends EntityRepositoryService<JobAdvertisement> {
	List<JobAdvertisement> getByJobName(String jobName);

	List<JobAdvertisement> getByCompanyName(String companyName);

	List<JobAdvertisement> getByActive(boolean active);
	
	List<JobAdvertisement> getByEarlyDate();
	
	List<JobAdvertisement> getByLastDate();
}
