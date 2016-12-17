package com.okorkut.ik.service;

import com.okorkut.ik.dto.UserDto;

public interface UserService {

	/**
	 * Eposta ve sifre kullanilarak musteri dondurulur.
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public UserDto getUserByEmailAndPassword(String email, String password) throws Exception;

	public void save(UserDto userDto) throws Exception;

}
