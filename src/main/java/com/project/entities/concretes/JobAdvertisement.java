package com.project.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "jobAdvertisement")

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "companyName" ,nullable = false)
	private String companyName;
	@Column(name = "numberOfPersonnelSought")
	private int numberOfPersonnelSought;
	@Column(name = "jobName",nullable = false)
	private String jobName;
	@Column(name = "description",nullable = false)
	private String description;
	@Column(name = "city")
	private String city;
	@Column(name = "minSalary",nullable = true)
	private int minSalary;
	@Column(name = "maxSalary",nullable = true)
	private int maxSalary;
	@Temporal(TemporalType.DATE)
	@Column(name = "applicationDeadline")
	private Date applicationDeadline;
	@Column(name = "active",nullable = false)
	private boolean active;

	public JobAdvertisement() {
	}

	public JobAdvertisement(String companyName, int numberOfPersonnelSought, String jobName, String description,
			String city, int minSalary, int maxSalary, Date applicationDeadline, boolean active) {
		this.companyName = companyName;
		this.numberOfPersonnelSought = numberOfPersonnelSought;
		this.jobName = jobName;
		this.description = description;
		this.city = city;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.applicationDeadline = applicationDeadline;
		this.active = active;
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

	public int getNumberOfPersonnelSought() {
		return numberOfPersonnelSought;
	}

	public void setNumberOfPersonnelSought(int numberOfPersonnelSought) {
		this.numberOfPersonnelSought = numberOfPersonnelSought;
	}

	public String getjobName() {
		return jobName;
	}

	public void jobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "JobAdvertisement [id=" + id + ", companyName=" + companyName + ", numberOfPersonnelSought="
				+ numberOfPersonnelSought + ", jobName=" + jobName + ", description=" + description + ", city=" + city
				+ ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + ", applicationDeadline="
				+ applicationDeadline + ", active=" + active + "]";
	}

}
