package com.okorkut.ik.common.dao;

import java.util.List;

import com.okorkut.ik.common.entity.History;

public interface HistoryDao {

	public void save(History history) throws Exception;

	public void update(History history) throws Exception;

	public List<History> getTasksByRoles(List<String> roles) throws Exception;

}
