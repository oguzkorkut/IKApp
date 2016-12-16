package com.okorkut.ik.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "applicationDto")
public class ApplicationDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private boolean active;
	private Timestamp applicationDate;
	private String result;
	private PositionDto positionDto;

	public ApplicationDto() {
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

	public Timestamp getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Timestamp applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public PositionDto getPositionDto() {
		return positionDto;
	}

	public void setPositionDto(PositionDto positionDto) {
		this.positionDto = positionDto;
	}

}