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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	private byte active;

	// bi-directional many-to-one association to Role
	// @OneToOne(fetch=FetchType.LAZY)
	// @JoinColumn(name="ROLE_ID", nullable=false, insertable=false,
	// updatable=false)
	// private Role role;
	// @OneToOne(mappedBy="roleGroup")
	// private Role role;
	// @JoinColumn(name="ROLE_ID", nullable=false, insertable=false,
	// updatable=false)
	// @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	// @Fetch(value = FetchMode.SELECT)
	// private Role role;

	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	@JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
	private Role role;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	private User user;

	public RoleGroup() {
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(final byte active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(final Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

}