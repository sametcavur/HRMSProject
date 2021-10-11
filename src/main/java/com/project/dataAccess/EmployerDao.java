package com.project.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Long>{

}
