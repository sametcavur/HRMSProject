package com.project.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entities.concretes.JobAdvertisement;
@Repository
public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisement, Long>{
	@Query(value = "SELECT * FROM job_advertisement WHERE job_advertisement.job_name = ?1",nativeQuery = true)
    List<JobAdvertisement> getByJobName(String jobName);
	
	@Query(value = "SELECT * FROM job_advertisement WHERE job_advertisement.company_name = ?1",nativeQuery = true)
    List<JobAdvertisement> getByCompanyName(String companyName);
	
	@Query(value = "SELECT * FROM job_advertisement WHERE job_advertisement.active =?1",nativeQuery = true)
    List<JobAdvertisement> getByActive(boolean active);
	
	@Query(value = "SELECT * FROM job_advertisement ORDER BY application_deadline ASC;",nativeQuery = true)
    List<JobAdvertisement> getByEarlyDate();
	
	@Query(value = "SELECT * FROM job_advertisement ORDER BY application_deadline DESC;",nativeQuery = true)
    List<JobAdvertisement> getByLastDate();
	
}
