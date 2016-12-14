//package com.okorkut.ik.common.entity2;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.util.List;
//
//
///**
// * The persistent class for the role database table.
// * 
// */
//@Entity
//@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
//@Table(name="Role")
//public class Role implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	private int id;
//
//	@Column(name="ROLE_NAME")
//	private String roleName;
//
//	//bi-directional many-to-one association to User
//	@OneToMany(mappedBy="role")
//	private List<User> users;
//
//	public Role() {
//	}
//
//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getRoleName() {
//		return this.roleName;
//	}
//
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}
//
//	public List<User> getUsers() {
//		return this.users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
//
//	public User addUser(User user) {
//		getUsers().add(user);
//		user.setRole(this);
//
//		return user;
//	}
//
//	public User removeUser(User user) {
//		getUsers().remove(user);
//		user.setRole(null);
//
//		return user;
//	}
//
//}