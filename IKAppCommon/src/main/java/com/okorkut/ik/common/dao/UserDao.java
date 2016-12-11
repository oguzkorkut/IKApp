package com.okorkut.ik.common.dao;

import com.okorkut.ik.common.entity.User;

public interface UserDao {
	
	public User getUserByEmailAndPassword(String email,String password) throws Exception;

	public User save(User userDto);
	
	public User getUserDtoByEmail(String emial);
	
	public void save2(User userDto);
	
	public User getUserDtoByEmail2(String emial);
}
