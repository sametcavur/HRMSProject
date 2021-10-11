package com.project.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.entities.abstracts.Person;

@Entity
@Table(name = "JobSeeker")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume" })
public class JobSeeker extends Person {
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

	@Column(name = "title")
	private String title;

	@Column(name = "password")
	private String password;
	
	@JoinColumn(name = "id", referencedColumnName = "id")
	@JsonBackReference	
	@OneToOne(cascade = CascadeType.ALL)
	private Resume resume;

	public JobSeeker() {
	}

	public JobSeeker(long id, String name, String lastName, int age, String nationalIdentityNumber, String email,
			String title, String password, Resume resume) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.nationalIdentityNumber = nationalIdentityNumber;
		this.email = email;
		this.title = title;
		this.password = password;
		this.resume = resume;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "JobSeeker [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age
				+ ", nationalIdentityNumber=" + nationalIdentityNumber + ", email=" + email + ", title=" + title
				+ ", password=" + password + ", resume=" + resume + "]";
	}

}
