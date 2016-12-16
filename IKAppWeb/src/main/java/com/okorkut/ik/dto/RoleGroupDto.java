package com.okorkut.ik.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "roleGroupDto")
public class RoleGroupDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private boolean active;

	private RoleDto dto;

	public RoleGroupDto() {
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

	public RoleDto getDto() {
		return dto;
	}

	public void setDto(RoleDto dto) {
		this.dto = dto;
	}

}