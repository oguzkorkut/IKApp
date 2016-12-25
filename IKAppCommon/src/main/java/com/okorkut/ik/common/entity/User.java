package com.okorkut.ik.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.entity.listener.UserListener;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@EntityListeners(UserListener.class)
// @NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findGetUserByEmailAndPassword", query = "SELECT u FROM User u where u.email = :email and u.password=:password") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	@Column(name = "ACTIVE")
	private boolean active;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_AT")
	private Date createdAt;

	@Column(name = "CREATED_BY", length = 50)
	private String createdBy;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "LASTNAME", length = 50)
	private String lastname;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "PASSWORD", length = 50)
	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_AT")
	private Date updatedAt;

	@Column(name = "UPDATED_BY", length = 50)
	private String updatedBy;

	@Column(name = "USER_NAME", length = 50)
	private String userName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Application> applications;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Education> educations;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Experience> experiences;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Certificate> certificates;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Language> languages;

	// @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PROFILE_ID")
	private Profile profile;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Reference> references;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<RoleGroup> roleGroups;

	public User() {
	}

	public User(List<Application> applications, List<Education> educations, List<Experience> experiences, List<Certificate> certificates,
			List<Language> languages, Profile profile, List<Reference> references, List<RoleGroup> roleGroups) {
		this.applications = applications;
		this.educations = educations;
		this.experiences = experiences;
		this.certificates = certificates;
		this.languages = languages;
		this.profile = profile;
		this.references = references;
		this.roleGroups = roleGroups;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Application> getApplications() {
		return applications;
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
		return educations;
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
		return experiences;
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
		return languages;
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

	// public List<Profile> getProfiles() {
	// return this.profiles;
	// }
	//
	// public void setProfiles(List<Profile> profiles) {
	// this.profiles = profiles;
	// }
	//
	// public Profile addProfile(Profile profile) {
	// getProfiles().add(profile);
	// profile.setUser(this);
	//
	// return profile;
	// }
	//
	// public Profile removeProfile(Profile profile) {
	// getProfiles().remove(profile);
	// profile.setUser(null);
	//
	// return profile;
	// }

	public Profile getProfile() {
		return profile;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Reference> getReferences() {
		return references;
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
		return roleGroups;
	}

	public void setRoleGroups(List<RoleGroup> roleGroups) {
		this.roleGroups = roleGroups;
	}

	public RoleGroup addRoleGroup(RoleGroup roleGroup) {
		if (CollectionUtils.isEmpty(roleGroups)) {
			roleGroups = new ArrayList<RoleGroup>();
		}
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