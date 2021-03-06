package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.common.entity.Role;
import com.okorkut.ik.common.entity.RoleGroup;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("roleDaoImpl")
public class RoleDaoImpl extends BaseDao implements RoleDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RoleDaoImpl.class);

	// private SessionFactory sessionFactory;

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	// public SessionFactory getSessionFactory() {
	// return sessionFactory;
	// }
	//
	// public void setSessionFactory(SessionFactory sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }

	@Override
	public Role getRoleById(Integer id) throws Exception {
		logger.info("getRoleById basladi. Id:" + id);

		Role role = null;

		try {
			role = (Role) manager.createNamedQuery("Role.findGetRoleById").setParameter("id", id).getSingleResult();

		} catch (NoResultException nre) {
			logger.info("Sonuc bulunamadi. id:" + id + " Detay Mesaj:" + nre.getMessage());
		} catch (Exception e) {
			logger.error(e, e);
		}

		if (role != null) {
			appLoggerUtils.loggerObj(role, role.getClass());
		}
		logger.info("getRoleById bitti.");
		return role;
	}

	@Override
	@Transactional
	public RoleGroup save(RoleGroup roleGroup) throws Exception {
		logger.info("RoleGroup bilgileri kaydediliyor.");

		try {
			manager.persist(roleGroup);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		logger.info("RoleGroup bilgileri kaydi bitti . ID:" + roleGroup.getId());
		return roleGroup;
	}

}
