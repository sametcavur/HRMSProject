package com.project.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface EntityRepositoryService <T>{

	void add(T entity);
	void update(T entity);
	void delete(T entity);
	List<T> getAll();
}

