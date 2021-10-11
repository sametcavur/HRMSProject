package com.project.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "resume")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "graduatedSchool")
	private String graduatedSchool;

	@Column(name = "graduatedYear", nullable = true)
	private Date graduatedYear;

	@Column(name = "workExperience")
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<WorkExperience> workExperience;

	@Column(name = "knownLanguage")
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<KnownLanguage> knownLanguage;

	@Column(name = "image")
	private String image;

	@Column(name = "githubLink")
	private String githubLink;

	@Column(name = "linkedinLink")
	private String linkedinLink;

	@Column(name = "knownTechnologies")
	private String knownTechnologies;

	@Column(name = "coverLetter")
	private String coverLetter;
	
	@OneToOne(mappedBy = "resume",cascade = CascadeType.ALL)
	@JsonBackReference
	private JobSeeker jobSeeker;
	

	public Resume() {
		// TODO Auto-generated constructor stub
	}

	public Resume(long id, String graduatedSchool, Date graduatedYear, List<WorkExperience> workExperience,
			List<KnownLanguage> knownLanguage, String image, String githubLink, String linkedinLink,
			String knownTechnologies, String coverLetter, JobSeeker jobSeeker) {
		super();
		this.id = id;
		this.graduatedSchool = graduatedSchool;
		this.graduatedYear = graduatedYear;
		this.workExperience = workExperience;
		this.knownLanguage = knownLanguage;
		this.image = image;
		this.githubLink = githubLink;
		this.linkedinLink = linkedinLink;
		this.knownTechnologies = knownTechnologies;
		this.coverLetter = coverLetter;
		this.jobSeeker = jobSeeker;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGraduatedSchool() {
		return graduatedSchool;
	}

	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}

	public Date getGraduatedYear() {
		return graduatedYear;
	}

	public void setGraduatedYear(Date graduatedYear) {
		this.graduatedYear = graduatedYear;
	}

	public List<WorkExperience> getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(List<WorkExperience> workExperience) {
		this.workExperience = workExperience;
	}

	public List<KnownLanguage> getKnownLanguage() {
		return knownLanguage;
	}

	public void setKnownLanguage(List<KnownLanguage> knownLanguage) {
		this.knownLanguage = knownLanguage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public String getLinkedinLink() {
		return linkedinLink;
	}

	public void setLinkedinLink(String linkedinLink) {
		this.linkedinLink = linkedinLink;
	}

	public String getKnownTechnologies() {
		return knownTechnologies;
	}

	public void setKnownTechnologies(String knownTechnologies) {
		this.knownTechnologies = knownTechnologies;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	@Override
	public String toString() {
		return "Resume [id=" + id + ", graduatedSchool=" + graduatedSchool + ", graduatedYear=" + graduatedYear
				+ ", workExperience=" + workExperience + ", knownLanguage=" + knownLanguage + ", image=" + image
				+ ", githubLink=" + githubLink + ", linkedinLink=" + linkedinLink + ", knownTechnologies="
				+ knownTechnologies + ", coverLetter=" + coverLetter + ", jobSeeker=" + jobSeeker + "]";
	}

}
