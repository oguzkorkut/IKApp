package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
//@NamedQuery(name = "user.deleteById", query = "DELETE FROM user a where a.id in (:idList)"
@NamedQueries({ @NamedQuery(name = "User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name = "User.findGetUserByEmailAndPassword", query = "SELECT u FROM User u where u.email = :email and u.password=:password"),
	 })
@Table(name="User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte active;

	@Column(name="CREATED_AT")
	private Timestamp createdAt;

	@Column(name="CREATED_BY")
	private String createdBy;

	private String email;

	private String lastname;

	private String name;

	private String password;

	@Column(name="UPDATED_AT")
	private Timestamp updatedAt;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Column(name="USER_NAME")
	private String userName;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
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
			append("userName:" + userName).append("\n").
			append("role:" + role);
		
		return str.toString();
	}

}