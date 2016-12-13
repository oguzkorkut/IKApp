package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the education database table.
 * 
 */
@Entity
@Table(name="education")
@NamedQuery(name="Education.findAll", query="SELECT e FROM Education e")
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private EducationPK id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="BEGIN_DATE")
	private Timestamp beginDate;

	@Column(length=50)
	private String department;

	@Column(name="EDUCATION_LEVEL", length=20)
	private String educationLevel;

	@Column(name="END_DATE")
	private Timestamp endDate;

	@Column(length=10)
	private String grade;

	@Column(name="GRADE_SYSTEM", length=10)
	private String gradeSystem;

	@Column(name="PHONE_NUMBER", length=20)
	private String phoneNumber;

	@Column(name="SCHOOL_NAME", length=50)
	private String schoolName;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false, insertable=false, updatable=false)
	private User user;

	public Education() {
	}

//	public EducationPK getId() {
//		return this.id;
//	}
//
//	public void setId(EducationPK id) {
//		this.id = id;
//	}

	public Timestamp getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Timestamp beginDate) {
		this.beginDate = beginDate;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEducationLevel() {
		return this.educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGradeSystem() {
		return this.gradeSystem;
	}

	public void setGradeSystem(String gradeSystem) {
		this.gradeSystem = gradeSystem;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}