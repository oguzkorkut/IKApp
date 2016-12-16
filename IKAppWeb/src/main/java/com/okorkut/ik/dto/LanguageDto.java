package com.okorkut.ik.dto;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "languageDto")
public class LanguageDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private byte active;
	private String language;
	private String reading;
	private String speaking;
	private String writing;

	public LanguageDto() {
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

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getReading() {
		return this.reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public String getSpeaking() {
		return this.speaking;
	}

	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}

	public String getWriting() {
		return this.writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}
}