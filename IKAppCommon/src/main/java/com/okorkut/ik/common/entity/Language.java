package com.okorkut.ik.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the language database table.
 * 
 */
@Entity
@Table(name = "language")
@NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "LANGUAGE", length = 50)
	private String language;

	@Column(name = "READING", length = 10)
	private int reading;

	@Column(name = "SPEAKING", length = 45)
	private int speaking;

	@Column(name = "WRITING", length = 10)
	private int writing;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private User user;

	public Language() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getReading() {
		return reading;
	}

	public void setReading(int reading) {
		this.reading = reading;
	}

	public int getSpeaking() {
		return speaking;
	}

	public void setSpeaking(int speaking) {
		this.speaking = speaking;
	}

	public int getWriting() {
		return writing;
	}

	public void setWriting(int writing) {
		this.writing = writing;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}