package com.okorkut.ik.common.entity.listener;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.okorkut.ik.common.entity.User;

public class UserListener {

	@PrePersist
	public void userPrePersist(User user) {
		System.out.println("Listening User Pre Persist : " + user.getName());

		user.setCreatedAt(new Timestamp(new Date().getTime()));
		user.setCreatedBy("SYSTEM");
		user.setUpdatedAt(new Timestamp(new Date().getTime()));
		user.setUpdatedBy("SYSTEM");
		user.setActive(true);
	}

	@PostPersist
	public void userPostPersist(User user) {
		System.out.println("Listening User Post Persist : " + user.getName());

	}

	@PostLoad
	public void userPostLoad(User user) {
		System.out.println("Listening User Post Load : " + user.getName());

		// user.setCreatedAt(new Timestamp(new Date().getTime()));
		// user.setCreatedBy("SYSTEM");
		// user.setUpdatedAt(new Timestamp(new Date().getTime()));
		// user.setUpdatedBy("SYSTEM");
	}

	@PreUpdate
	public void userPreUpdate(User user) {
		System.out.println("Listening User Pre Update : " + user.getName());

		user.setUpdatedAt(new Timestamp(new Date().getTime()));
		user.setUpdatedBy("SYSTEM");
	}

	@PostUpdate
	public void userPostUpdate(User user) {
		System.out.println("Listening User Post Update : " + user.getName());

		// user.setCreatedAt(new Timestamp(new Date().getTime()));
		// user.setCreatedBy("SYSTEM");
		// user.setUpdatedAt(new Timestamp(new Date().getTime()));
		// user.setUpdatedBy("SYSTEM");
	}

	@PreRemove
	public void userPreRemove(User user) {
		System.out.println("Listening User Pre Remove : " + user.getName());

	}

	@PostRemove
	public void userPostRemove(User user) {
		System.out.println("Listening User Post Remove : " + user.getName());

	}

}
