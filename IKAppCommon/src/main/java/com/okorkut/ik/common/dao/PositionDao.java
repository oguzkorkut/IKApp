package com.okorkut.ik.common.dao;

import java.util.List;

import com.okorkut.ik.common.entity.Position;

public interface PositionDao {

	public Position add(Position position) throws Exception;

	public boolean update(Position position) throws Exception;

	public boolean delete(Integer id) throws Exception;

	public List<Position> getPositions() throws Exception;

	public List<Position> getPositionsByUserId(Integer userId) throws Exception;

}
