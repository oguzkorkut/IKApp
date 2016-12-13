package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.sql.Timestamp;


/**
 * The persistent class for the application database table.
 * 
 */
@Entity
@Table(name="application")
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private ApplicationPK id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private byte active;

	@Column(name="APPLICATION_DATE")
	private Timestamp applicationDate;

	@Column(length=10)
	private String result;

//	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
//	@JoinColumn(name="POSITION_ID", nullable=false, insertable=false, updatable=false)
//	private Position position;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@JoinColumn(name = "POSITION_ID",  insertable = false, updatable = false)
	private Position position;

	//bi-directional many-to-one association to User
//	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
//	@JoinColumn(name="USER_ID", nullable=false, insertable=false, updatable=false)
//	private User user;
	
//	@ManyToOne(fetch=FetchType.LAZY,targetEntity = User.class)
//	@JoinColumn(name="USER_ID", insertable=false, updatable=false, unique=true, nullable=false)
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	public Application() {
	}

//	public ApplicationPK getId() {
//		return this.id;
//	}
//
//	public void setId(ApplicationPK id) {
//		this.id = id;
//	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Timestamp getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(Timestamp applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}