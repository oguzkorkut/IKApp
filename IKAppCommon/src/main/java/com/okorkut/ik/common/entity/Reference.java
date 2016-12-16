package com.okorkut.ik.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the references database table.
 * 
 */
@Entity
@Table(name="references")
@NamedQuery(name="Reference.findAll", query="SELECT r FROM Reference r")
public class Reference implements Serializable {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private ReferencePK id;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private byte active;

	@Column(length=50)
	private String email;

	@Column(nullable=false, length=50)
	private String lastname;

	@Column(name="MOBILE_PHONE", nullable=false, length=20)
	private String mobilePhone;

	@Column(nullable=false, length=50)
	private String name;

	@Column(nullable=false, length=50)
	private String position;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false, insertable=false, updatable=false)
	private User user;

	public Reference() {
	}

//	public ReferencePK getId() {
//		return this.id;
//	}
//
//	public void setId(ReferencePK id) {
//		this.id = id;
//	}

	public byte getActive() {
		return this.active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}