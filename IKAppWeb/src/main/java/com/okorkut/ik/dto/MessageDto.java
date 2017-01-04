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
@XmlRootElement(name = "messageDto")
public class MessageDto {

	private Integer id;
	private Date taskAssignDate;
	private Date taskCompletionDate;
	private String result;
	private String comment;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


}
