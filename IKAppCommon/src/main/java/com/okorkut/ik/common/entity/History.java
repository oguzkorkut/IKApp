package com.okorkut.ik.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "history")
@NamedQueries({ @NamedQuery(name = "History.findAll", query = "SELECT a FROM History a"),
		@NamedQuery(name = "History.findGetTasksByRoleId", query = "select h from History h "
				+ "left join fetch h.role where  h.role.roleName IN  (?1) and h.active = true"),
		@NamedQuery(name = "History.findGetHistoryById", query = "select h from History h where h.id=:id"),
		@NamedQuery(name = "History.findGetMessagesByUserId", query = "select h from History h " + "left join fetch h.application "
				+ "where h.application.userId = :userId and h.active = false") })
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

	@Column(name = "ROLE_ID")
	private Integer roleId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	private Role role;

	/*
	 * Kontrol eden kişi
	 */
	@Column(name = "USER_ID")
	private Integer userId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_HISTORY_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	private User userHistory;


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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
