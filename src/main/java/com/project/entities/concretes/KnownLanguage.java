package com.project.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "knownLanguage")
public class KnownLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "language")
	private String language;
	@Column(name = "level")
	private int level;

	public KnownLanguage() {
	}

	public KnownLanguage(String language, int level) {
		this.language = language;
		this.level = level;
	}

	public long getId() {
		return id;
	}


	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "KnownLanguage [id=" + id + ", language=" + language + ", level=" + level + "]";
	}
}
