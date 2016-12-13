package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@NamedQueries({ @NamedQuery(name = "User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name = "User.findGetUserByEmailAndPassword", query = "SELECT u FROM User u where u.email = :email and u.password=:password"),
 })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private byte active;

	@Column(name="CREATED_AT")
	private Timestamp createdAt;

	@Column(name="CREATED_BY", length=50)
	private String createdBy;

	@Column(nullable=false, length=50)
	private String email;

	@Column(nullable=false, length=50)
	private String lastname;

	@Column(nullable=false, length=50)
	private String name;

	@Column(nullable=false, length=50)
	private String password;

	@Column(name="UPDATED_AT")
	private Timestamp updatedAt;

	@Column(name="UPDATED_BY", length=50)
	private String updatedBy;

	@Column(name="USER_NAME", nullable=false, length=50)
	private String userName;

	//bi-directional many-to-one association to Application
//	@OneToMany(mappedBy="user")
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//	@JoinColumn(name="USER_ID", nullable=false)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Application> applications;

	//bi-directional many-to-one association to Education
	@OneToMany(mappedBy="user")
	private List<Education> educations;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	private List<Experience> experiences;

	//bi-directional many-to-one association to Language
	@OneToMany(mappedBy="user")
	private List<Language> languages;

	//bi-directional many-to-one association to Profile
	@OneToOne(mappedBy="user")
	private Profile profile;

	//bi-directional many-to-one association to Reference
	@OneToMany(mappedBy="user")
	private List<Reference> references;

	//bi-directional many-to-one association to RoleGroup
	@OneToMany(mappedBy="user")
	private List<RoleGroup> roleGroups;

	public User() {
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

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application addApplication(Application application) {
		getApplications().add(application);
		application.setUser(this);

		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		application.setUser(null);

		return application;
	}

	public List<Education> getEducations() {
		return this.educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public Education addEducation(Education education) {
		getEducations().add(education);
		education.setUser(this);

		return education;
	}

	public Education removeEducation(Education education) {
		getEducations().remove(education);
		education.setUser(null);

		return education;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setUser(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setUser(null);

		return experience;
	}

	public List<Language> getLanguages() {
		return this.languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Language addLanguage(Language language) {
		getLanguages().add(language);
		language.setUser(this);

		return language;
	}

	public Language removeLanguage(Language language) {
		getLanguages().remove(language);
		language.setUser(null);

		return language;
	}
	

//	public List<Profile> getProfiles() {
//		return this.profiles;
//	}
//
//	public void setProfiles(List<Profile> profiles) {
//		this.profiles = profiles;
//	}
//
//	public Profile addProfile(Profile profile) {
//		getProfiles().add(profile);
//		profile.setUser(this);
//
//		return profile;
//	}
//
//	public Profile removeProfile(Profile profile) {
//		getProfiles().remove(profile);
//		profile.setUser(null);
//
//		return profile;
//	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Reference> getReferences() {
		return this.references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}

	public Reference addReference(Reference reference) {
		getReferences().add(reference);
		reference.setUser(this);

		return reference;
	}

	public Reference removeReference(Reference reference) {
		getReferences().remove(reference);
		reference.setUser(null);

		return reference;
	}

	public List<RoleGroup> getRoleGroups() {
		return this.roleGroups;
	}

	public void setRoleGroups(List<RoleGroup> roleGroups) {
		this.roleGroups = roleGroups;
	}

	public RoleGroup addRoleGroup(RoleGroup roleGroup) {
		getRoleGroups().add(roleGroup);
		roleGroup.setUser(this);

		return roleGroup;
	}

	public RoleGroup removeRoleGroup(RoleGroup roleGroup) {
		getRoleGroups().remove(roleGroup);
		roleGroup.setUser(null);

		return roleGroup;
	}

}