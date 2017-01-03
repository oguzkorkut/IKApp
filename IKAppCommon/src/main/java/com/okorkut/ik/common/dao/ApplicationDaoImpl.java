package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.common.entity.Application;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("applicationDaoImpl")
public class ApplicationDaoImpl extends BaseDao implements ApplicationDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ApplicationDaoImpl.class);

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public void save(Application application) throws Exception {
		logger.info("badvuru kaydediliyor.");

		try {
			manager.persist(application);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			appLoggerUtils.loggerObj(application, Application.class);
		}

		logger.info("BAsvuru kaydedildi. ID:" + application.getId());
	}

}
