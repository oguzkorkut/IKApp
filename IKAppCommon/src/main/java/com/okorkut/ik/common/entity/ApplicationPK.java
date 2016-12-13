package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the application database table.
 * 
 */
@Embeddable
public class ApplicationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="USER_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private int userId;

	@Column(name="POSITION_ID", insertable=false, updatable=false, unique=true, nullable=false)
	private int positionId;

	public ApplicationPK() {
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
	public int getPositionId() {
		return this.positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ApplicationPK)) {
			return false;
		}
		ApplicationPK castOther = (ApplicationPK)other;
		return 
			(this.id == castOther.id)
			&& (this.userId == castOther.userId)
			&& (this.positionId == castOther.positionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.positionId;
		
		return hash;
	}
}