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

import com.project.entities.abstracts.Person;

@Entity
@Table(name = "Personal")
public class Personal extends Person{
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

	@Column(name = "department")
	private String department;

	@Column(name = "salary")
	private double salary;

	@Column(name = "dateOfStart")
	@Temporal(TemporalType.DATE)
	private Date dateOfStart;

	public Personal() {
	}

	public Personal(String name, String lastName, int age, String nationalIdentityNumber, String email,
			String department, double salary, Date dateOfStart) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.nationalIdentityNumber = nationalIdentityNumber;
		this.email = email;
		this.department = department;
		this.salary = salary;
		this.dateOfStart = dateOfStart;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age
				+ ", nationalIdentityNumber=" + nationalIdentityNumber + ", email=" + email + ", department="
				+ department + ", salary=" + salary + ", dateOfStart=" + dateOfStart + "]";
	}

}