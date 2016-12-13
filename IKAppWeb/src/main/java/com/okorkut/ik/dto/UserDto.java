package com.okorkut.ik.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "userDto")
public class UserDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private byte active;
	private Timestamp createdAt;
	private String createdBy;
	private String email;
	private String lastname;
	private String name;
	private String password;
	private Timestamp updatedAt;
	private String updatedBy;
	private String userName;
//	private List<Application> applications;
//	private List<Education> educations;
//	private List<Experience> experiences;
//	private List<Language> languages;
//	private List<Profile> profiles;
//	private List<Reference> references;
	private List<String> userRoles;
	
//	private List<Role> roles;

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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
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

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
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

	
	public List<String> getUserRoles() {
		if (userRoles == null) {
			userRoles = new ArrayList<String>();
		}
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}
	
//
//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	@Override
	public String toString() {

		StringBuilder str = new StringBuilder();
		
		str.append("id:" + id).append("\n").
			append("active:" + active).append("\n").
			append("createdAt:" + createdAt).append("\n").
			append("createdBy:" + createdBy).append("\n").
			append("email:" + email).append("\n").
			append("lastname:" + lastname).append("\n").
			append("name:" + name).append("\n").
			append("password:" + password).append("\n").
			append("updatedAt:" + updatedAt).append("\n").
			append("updatedBy:" + updatedBy).append("\n").
			append("userName:" + userName).append("\n");
		
		return str.toString();
	}
	
	
}
