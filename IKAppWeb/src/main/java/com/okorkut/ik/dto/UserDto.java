package com.okorkut.ik.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.okorkut.ik.common.entity.RoleGroup;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "userDto")
public class UserDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private byte active;
	private Date createdAt;
	private String createdBy;
	private String email;
	private String lastname;
	private String name;
	private String password;
	private Date updatedAt;
	private String updatedBy;
	private String userName;
	private String address;

	private List<ApplicationDto> applications;
	private List<EducationDto> educations;
	private List<ExperienceDto> experiences;
	private List<LanguageDto> languages;
	private ProfileDto profileDto;
	private List<ReferenceDto> references;
	private List<RoleGroup> roleGroups;
	private List<CertificateDto> certificateDtos;

	public UserDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
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

	public List<ApplicationDto> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationDto> applications) {
		this.applications = applications;
	}

	public List<EducationDto> getEducations() {
		return educations;
	}

	public void setEducations(List<EducationDto> educations) {
		this.educations = educations;
	}

	public List<ExperienceDto> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<ExperienceDto> experiences) {
		this.experiences = experiences;
	}

	public List<LanguageDto> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageDto> languages) {
		this.languages = languages;
	}

	public ProfileDto getProfileDto() {
		return profileDto;
	}

	public void setProfileDto(ProfileDto profileDto) {
		this.profileDto = profileDto;
	}

	public List<ReferenceDto> getReferences() {
		return references;
	}

	public void setReferences(List<ReferenceDto> references) {
		this.references = references;
	}

	public List<RoleGroup> getRoleGroups() {
		return roleGroups;
	}

	public void setRoleGroups(List<RoleGroup> roleGroups) {
		this.roleGroups = roleGroups;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<CertificateDto> getCertificateDtos() {
		return certificateDtos;
	}

	public void setCertificateDtos(List<CertificateDto> certificateDtos) {
		this.certificateDtos = certificateDtos;
	}

}