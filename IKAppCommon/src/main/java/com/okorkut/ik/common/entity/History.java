package com.okorkut.ik.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "history")
@NamedQuery(name = "History.findAll", query = "SELECT a FROM History a")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "APPLICATION_ID")
	private Integer applicationId;

	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_ASSIGN_DATE")
	private Date taskAssignDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_COMPLETION_DATE")
	private Date taskCompletionDate;

	@Column(name = "USER_ACTION")
	private String userAction;

	@Column(name = "USER_COMMENT")
	private String userComment;

	@Column(name = "ACTIVE")
	private boolean active;

	/*
	 * Kontrol eden kişi
	 */
	@Column(name = "USER_ID")
	private Integer userId;

	// @ManyToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	// private User user;

	// @ManyToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "APPLICATION_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	// private Application applicationID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPLICATION_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	private Application application;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Date getTaskAssignDate() {
		return taskAssignDate;
	}

	public void setTaskAssignDate(Date taskAssignDate) {
		this.taskAssignDate = taskAssignDate;
	}

	public Date getTaskCompletionDate() {
		return taskCompletionDate;
	}

	public void setTaskCompletionDate(Date taskCompletionDate) {
		this.taskCompletionDate = taskCompletionDate;
	}

	public String getUserAction() {
		return userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
