package com.project.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.concretes.Resume;

@Repository
public interface ResumeDao extends JpaRepository<Resume, Long>{

}
