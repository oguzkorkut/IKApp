package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the language database table.
 * 
 */
@Entity
@Table(name="language")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private LanguagePK id;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private byte active;

	@Column(nullable=false, length=50)
	private String language;

	@Column(nullable=false, length=10)
	private String reading;

	@Column(nullable=false, length=45)
	private String speaking;

	@Column(nullable=false, length=10)
	private String writing;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false, insertable=false, updatable=false)
	private User user;

	public Language() {
	}

//	public LanguagePK getId() {
//		return this.id;
//	}
//
//	public void setId(LanguagePK id) {
//		this.id = id;
//	}

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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}