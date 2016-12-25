package com.okorkut.ik.service;

import java.util.List;

import com.okorkut.ik.dto.PositionDto;
import com.okorkut.ik.dto.RoleDto;
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

	public RoleDto getRoleDtoById(Integer id) throws Exception;

	public List<PositionDto> getPositions() throws Exception;

	public PositionDto addPosition(PositionDto positionDto) throws Exception;

	public boolean updatePosition(PositionDto positionDto) throws Exception;

	public boolean deletePosition(Integer id) throws Exception;

	public void applyPositionByPositionId(Integer userId, Integer positionId) throws Exception;

	public List<PositionDto> getPositionsByUserId(Integer userId) throws Exception;

	public UserDto getUserProfileById(Integer id) throws Exception;

}
