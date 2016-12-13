package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the position database table.
 * 
 */
@Entity
@Table(name="position")
@NamedQuery(name="Position.findAll", query="SELECT p FROM Position p")
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private byte active;

	@Column(name="BEGIN_DATE", nullable=false)
	private Timestamp beginDate;

	@Column(name="END_DATE", nullable=false)
	private Timestamp endDate;

	@Column(nullable=false, length=50)
	private String name;

	//bi-directional many-to-one association to Application
//	@OneToOne(mappedBy="position", cascade={CascadeType.ALL})
//	private Application application;

	public Position() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
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

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Application getApplication() {
//		return application;
//	}
//
//	public void setApplication(Application application) {
//		this.application = application;
//	}
	
	

//	public List<Application> getApplications() {
//		return this.applications;
//	}
//
//	public void setApplications(List<Application> applications) {
//		this.applications = applications;
//	}
//
//	public Application addApplication(Application application) {
//		getApplications().add(application);
//		application.setPosition(this);
//
//		return application;
//	}
//
//	public Application removeApplication(Application application) {
//		getApplications().remove(application);
//		application.setPosition(null);
//
//		return application;
//	}

}