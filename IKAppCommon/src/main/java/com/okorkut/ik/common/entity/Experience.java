package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the experience database table.
 * 
 */
@Entity
@Table(name="experience")
@NamedQuery(name="Experience.findAll", query="SELECT e FROM Experience e")
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private ExperiencePK id;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private byte active;

	@Column(name="BEGIN_DATE")
	private Timestamp beginDate;

	@Column(nullable=false, length=50)
	private String company;

	@Column(name="END_DATE")
	private Timestamp endDate;

	@Column(length=50)
	private String position;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false, insertable=false, updatable=false)
	private User user;

	public Experience() {
	}

//	public ExperiencePK getId() {
//		return this.id;
//	}
//
//	public void setId(ExperiencePK id) {
//		this.id = id;
//	}
	
	

	public byte getActive() {
		return this.active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Timestamp getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Timestamp beginDate) {
		this.beginDate = beginDate;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}