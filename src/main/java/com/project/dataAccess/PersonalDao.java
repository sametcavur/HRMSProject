package com.project.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.concretes.Personal;
@Repository
public interface PersonalDao extends JpaRepository<Personal,Long>{

}
