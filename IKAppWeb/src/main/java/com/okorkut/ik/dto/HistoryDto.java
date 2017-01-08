package com.okorkut.ik.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author oguz
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "history")
public class HistoryDto {

	private Integer id;
	private Integer applicationId;
	private Date taskAssignDate;
	private Date taskCompletionDate;
	private String userAction;
	private String userComment;
	private Integer userId;
	private String userName;
	private String position;
	private boolean active;
	private Integer applierId;
	private Integer roleId;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getApplierId() {
		return applierId;
	}

	public void setApplierId(Integer applierId) {
		this.applierId = applierId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
