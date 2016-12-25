package com.okorkut.ik.common.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	@Column(name = "ROLE_ID")
	private String roleID;

	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_ASSIGN_DATE")
	private Date taskAssignDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_COMPLETION_DATE")
	private Date taskCompletionDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_DUE_DATE")
	private Date taskDueDate;

	@Column(name = "TASK_ID")
	private Integer taskId;/* Jbpm Task Id */

	@Column(name = "USER_ACTION")
	private String userAction;

	@Column(name = "USER_COMMENT")
	private String userComment;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_ID")
	private Integer userId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
	private User user;

}
