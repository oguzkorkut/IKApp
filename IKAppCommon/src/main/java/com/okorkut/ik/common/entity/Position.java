package com.okorkut.ik.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the position database table.
 * 
 */
@Entity
@Table(name = "position")
@NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p")
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "BEGIN_DATE")
	private Timestamp beginDate;

	@Column(name = "END_DATE")
	private Timestamp endDate;

	@Column(name = "NAME", length = 50)
	private String name;

	// @OneToOne(mappedBy="position", cascade={CascadeType.ALL})
	// private Application application;

	public Position() {
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(final Timestamp beginDate) {
		this.beginDate = beginDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(final Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}