package com.okorkut.ik.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the application database table.
 * 
 */
@Entity
@Table(name = "application")
@NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "APPLICATION_DATE")
	private Timestamp applicationDate;

	@Column(name = "RESULT", length = 10)
	private String result;

	// @ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	// @JoinColumn(name="POSITION_ID", nullable=false, insertable=false,
	// updatable=false)
	// private Position position;

	@OneToOne
	// @Fetch(value = FetchMode.SELECT)
	@JoinColumn(name = "POSITION_ID", insertable = false, updatable = false, nullable = true)
	private Position position;

	// bi-directional many-to-one association to User
	// @ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	// @JoinColumn(name="USER_ID", nullable=false, insertable=false,
	// updatable=false)
	// private User user;

	// @ManyToOne(fetch=FetchType.LAZY,targetEntity = User.class)
	// @JoinColumn(name="USER_ID", insertable=false, updatable=false,
	// unique=true, nullable=false)
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumns({ @JoinColumn(name = "USER_ID", referencedColumnName = "ID",
	// insertable = false, updatable = false) })
	// @JoinColumn(name = "USER_ID")
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable =
	// false, updatable = false, nullable = true)
	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	private User user;

	public Application() {
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

	public Timestamp getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Timestamp applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}