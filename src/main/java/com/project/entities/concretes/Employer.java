package com.project.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.entities.abstracts.Person;

@Entity
@Table(name = "Employer")
public class Employer extends Person{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "nationalIdentityNumber")
	private String nationalIdentityNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "webSite")
	private String webSite;

	@Column(name = "password")
	private String password;

	@Column(name = "jobAdvertisement")
	@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisement;

	public Employer() {
	}

	public Employer( String name, String lastName, int age, String nationalIdentityNumber, String email,
			String webSite, String password, List<JobAdvertisement> jobAdvertisement) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.nationalIdentityNumber = nationalIdentityNumber;
		this.email = email;
		this.webSite = webSite;
		this.password = password;
		this.jobAdvertisement = jobAdvertisement;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationalIdentityNumber() {
		return nationalIdentityNumber;
	}

	public void setNationalIdentityNumber(String nationalIdentityNumber) {
		this.nationalIdentityNumber = nationalIdentityNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<JobAdvertisement> getJobAdvertisement() {
		return jobAdvertisement;
	}

	public void setJobAdvertisement(List<JobAdvertisement> jobAdvertisement) {
		this.jobAdvertisement = jobAdvertisement;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age
				+ ", nationalIdentityNumber=" + nationalIdentityNumber + ", email=" + email + ", webSite=" + webSite
				+ ", password=" + password + ", jobAdvertisement=" + jobAdvertisement + "]";
	}

}
