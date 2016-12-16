package com.okorkut.ik.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "applicationDto")
public class ApplicationDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private byte active;
	private Date applicationDate;
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



	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public PositionDto getPositionDto() {
		return this.positionDto;
	}

	public void setPositionDto(PositionDto positionDto) {
		this.positionDto = positionDto;
	}


}