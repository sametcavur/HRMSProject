package com.project.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workExperience")
public class WorkExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "companyName")
	private String companyName;
	@Column(name = "position")
	private String position;
	@Column(name = "year",nullable = true)
	private Date year;

	public WorkExperience() {
	}

	public WorkExperience(String companyName, String position, Date year) {
		super();
		this.companyName = companyName;
		this.position = position;
		this.year = year;
	}

	public long getId() {
		return id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "WorkExperience [id=" + id + ", companyName=" + companyName + ", position=" + position + ", year=" + year
				+ "]";
	}
}
