package com.okorkut.ik.common.dao;

import com.okorkut.ik.common.entity.User;

public interface UserDao {

	public User getUserByEmailAndPassword(String email, String password) throws Exception;

	public User save(User user) throws Exception;

	public User getUserDtoByEmail(String emial) throws Exception;

	public void save2(User userDto) throws Exception;

	public User getUserDtoByEmail2(String emial) throws Exception;

	public User getUserById(Integer id) throws Exception;
}
