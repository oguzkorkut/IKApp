package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@Table(name="profile")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private ProfilePK id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=250)
	private String address;

	@Column(name="BIRTH_DATE", nullable=false)
	private Timestamp birthDate;

	@Column(name="BIRTH_PLACE", nullable=false, length=50)
	private String birthPlace;

	@Column(name="DRIVING_LICENSE", length=2)
	private String drivingLicense;

	@Column(length=250)
	private String explanation;

	@Column(nullable=false, length=1)
	private String gender;

	@Column(name="PASSPORT_NUMBER", length=50)
	private String passportNumber;

	@Column(length=11)
	private String tc;

	//bi-directional many-to-one association to User
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false, insertable=false, updatable=false)
	private User user;

	public Profile() {
	}

//	public ProfilePK getId() {
//		return this.id;
//	}
//
//	public void setId(ProfilePK id) {
//		this.id = id;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getDrivingLicense() {
		return this.drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getExplanation() {
		return this.explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getTc() {
		return this.tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}