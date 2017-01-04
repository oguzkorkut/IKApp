package com.okorkut.ik.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the position database table.
 * 
 */
@Entity
@Table(name = "position")
@NamedQueries({ @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p"),
		@NamedQuery(name = "position.findGetPositionsByUserId", query = "select p from Position p where p.id not in (select app.positionId from Application app where app.userId = :userId)") })
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "ACTIVE")
	private boolean active;

	@Temporal(TemporalType.DATE)
	@Column(name = "BEGIN_DATE")
	private Date beginDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "DETAIL", length = 100)
	private String detail;

	// @OneToOne(mappedBy="position", cascade={CascadeType.ALL})
	// private Application application;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "position")
	private Application Application;

	public Position() {
	}

	public Position(Application Application) {
		this.Application = Application;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Application getApplication() {
		return Application;
	}

	public void setApplication(Application application) {
		Application = application;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}