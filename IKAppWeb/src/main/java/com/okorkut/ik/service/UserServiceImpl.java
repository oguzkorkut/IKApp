package com.okorkut.ik.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.okorkut.ik.common.dao.UserDao;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.UserDto;

public class UserServiceImpl implements UserService {
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {}
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * Eposta ve sifre kullanilarak musteri dondurulur.
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserDto getUserByEmailAndPassword(String email, String password) throws Exception {
		UserDto userDto = new UserDto();
		
		User user = userDao.getUserByEmailAndPassword(email, password);
		
		if (user != null) {
			BeanUtils.copyProperties(user, userDto);
		}else{
			return null;
		}
		return userDto;
	}

}
