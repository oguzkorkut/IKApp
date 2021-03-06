package com.okorkut.ik.common.entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the education database table.
 * 
 */
@Entity
@Table(name = "education")
@NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e")
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "EDUCATION_LEVEL", length = 20)
	private String educationLevel;

	@Temporal(TemporalType.DATE)
	@Column(name = "BEGIN_DATE")
	private Date beginDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "BRANCH", length = 50)
	private String branch;

	@Column(name = "GRADE", length = 10)
	private String grade;

	@Column(name = "GRADE_SYSTEM", length = 10)
	private String gradeSystem;

	@Column(name = "PHONE_NUMBER", length = 20)
	private String phoneNumber;

	@Column(name = "SCHOOL_NAME", length = 50)
	private String schoolName;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "USER_ID")
	private Integer userId;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	private User user;

	public Education() {
	}

	public Education(User user) {
		this.user = user;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGradeSystem() {
		return gradeSystem;
	}

	public void setGradeSystem(String gradeSystem) {
		this.gradeSystem = gradeSystem;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}