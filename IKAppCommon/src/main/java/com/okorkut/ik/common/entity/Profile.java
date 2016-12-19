package com.okorkut.ik.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@Table(name = "profile")
@NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "ADDRESS", length = 250)
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Column(name = "BIRTH_PLACE", length = 50)
	private String birthPlace;

	@Column(name = "DRIVING_LICENSE", length = 2)
	private String drivingLicense;

	@Column(name = "EXPLANATION", length = 250)
	private String explanation;

	@Column(name = "GENDER", length = 1)
	private int gender;

	@Column(name = "PASSPORT_NUMBER", length = 50)
	private String passportNumber;

	@Column(name = "TC", length = 11)
	private String tc;

	// @OneToOne(fetch = FetchType.LAZY)
	// // (cascade = { CascadeType.ALL })
	// @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable =
	// false, updatable = false, nullable = false)
	// private User user;

	// @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable =
	// false, updatable = false, nullable = false)
	// private User user;

	public Profile() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }

}