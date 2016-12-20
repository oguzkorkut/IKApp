package com.okorkut.ik.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the role_group database table.
 * 
 */
@Entity
@Table(name = "role_group")
@NamedQuery(name = "RoleGroup.findAll", query = "SELECT r FROM RoleGroup r")
public class RoleGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "ACTIVE")
	private boolean active;

	// @Column(name = "ROLE_ID")
	// private Integer roleId;

	// @Column(name = "USER_ID")
	// private Integer userId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	private Role role;

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	// private Role role;

	@Column(name = "USER_ID")
	private Integer userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	private User user;

	public RoleGroup() {
	}

	public RoleGroup(Role role, User user) {
		this.user = user;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	// public Integer getRoleId() {
	// return roleId;
	// }
	//
	// public void setRoleId(Integer roleId) {
	// this.roleId = roleId;
	// }
	//
	// public Integer getUserId() {
	// return userId;
	// }
	//
	// public void setUserId(Integer userId) {
	// this.userId = userId;
	// }

}