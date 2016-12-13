package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the role_group database table.
 * 
 */
@Embeddable
public class RoleGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="USER_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private int userId;

	@Column(name="ROLE_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private int roleId;

	public RoleGroupPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return this.roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RoleGroupPK)) {
			return false;
		}
		RoleGroupPK castOther = (RoleGroupPK)other;
		return 
			(this.id == castOther.id)
			&& (this.userId == castOther.userId)
			&& (this.roleId == castOther.roleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.roleId;
		
		return hash;
	}
}