package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="ROLE_NAME", nullable=false, length=30)
	private String roleName;

	//bi-directional many-to-one association to RoleGroup
//	@OneToOne(fetch = FetchType.LAZY,mappedBy="role")
//	private RoleGroup roleGroup;
	

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

//	public RoleGroup getRoleGroup() {
//		return roleGroup;
//	}
//
//	public void setRoleGroup(RoleGroup roleGroup) {
//		this.roleGroup = roleGroup;
//	}

}