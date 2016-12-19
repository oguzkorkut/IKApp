package com.okorkut.ik.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name = "role")
@NamedQueries({ @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
		@NamedQuery(name = "Role.findGetRoleById", query = "SELECT r FROM Role r where r.id =:id ") })
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "ROLE_NAME", length = 30)
	private String roleName;

	@OneToOne(mappedBy = "role")
	private RoleGroup roleGroup;

	public Role() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleGroup getRoleGroup() {
		return roleGroup;
	}

	public void setRoleGroup(RoleGroup roleGroup) {
		this.roleGroup = roleGroup;
	}

}