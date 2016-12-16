package com.okorkut.ik.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "certificateDto")
public class CertificateDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private byte active;
	private Date applicationDate;
	
	public CertificateDto() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	
	
	

}