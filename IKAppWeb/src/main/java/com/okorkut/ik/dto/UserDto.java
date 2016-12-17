package com.okorkut.ik.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "userDto")
public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private boolean active;
	private Date createdAt;
	private String createdBy;
	private String email;
	private String lastname;
	private String name;
	private String password;
	private Date updatedAt;
	private String updatedBy;
	private String userName;

	private List<ApplicationDto> applicationDtos;
	private List<EducationDto> educationDtos;
	private List<ExperienceDto> experienceDtos;
	private List<CertificateDto> certificateDtos;
	private List<LanguageDto> languageDtos;
	private ProfileDto profileDto;
	private List<ReferenceDto> referenceDtos;
	private List<RoleGroupDto> roleGroupDtos;

	public UserDto() {
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

	public List<ApplicationDto> getApplicationDtos() {
		return applicationDtos;
	}

	public void setApplicationDtos(List<ApplicationDto> applicationDtos) {
		this.applicationDtos = applicationDtos;
	}

	public List<EducationDto> getEducationDtos() {
		return educationDtos;
	}

	public void setEducationDtos(List<EducationDto> educationDtos) {
		this.educationDtos = educationDtos;
	}

	public List<ExperienceDto> getExperienceDtos() {
		return experienceDtos;
	}

	public void setExperienceDtos(List<ExperienceDto> experienceDtos) {
		this.experienceDtos = experienceDtos;
	}

	public List<CertificateDto> getCertificateDtos() {
		return certificateDtos;
	}

	public void setCertificateDtos(List<CertificateDto> certificateDtos) {
		this.certificateDtos = certificateDtos;
	}

	public List<LanguageDto> getLanguageDtos() {
		return languageDtos;
	}

	public void setLanguageDtos(List<LanguageDto> languageDtos) {
		this.languageDtos = languageDtos;
	}

	public ProfileDto getProfileDto() {
		return profileDto;
	}

	public void setProfileDto(ProfileDto profileDto) {
		this.profileDto = profileDto;
	}

	public List<ReferenceDto> getReferenceDtos() {
		return referenceDtos;
	}

	public void setReferenceDtos(List<ReferenceDto> referenceDtos) {
		this.referenceDtos = referenceDtos;
	}

	public List<RoleGroupDto> getRoleGroupDtos() {
		return roleGroupDtos;
	}

	public void setRoleGroupDtos(List<RoleGroupDto> roleGroupDtos) {
		this.roleGroupDtos = roleGroupDtos;
	}

}