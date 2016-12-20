package com.okorkut.ik.common.dao;

import com.okorkut.ik.common.entity.Role;
import com.okorkut.ik.common.entity.RoleGroup;

public interface RoleDao {

	public Role getRoleById(Integer id) throws Exception;

	public RoleGroup save(RoleGroup roleGroup) throws Exception;

}
