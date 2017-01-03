package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.common.entity.Application;
import com.okorkut.ik.common.entity.History;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("historyDaoImpl")
public class HistoryDaoImpl extends BaseDao implements HistoryDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(HistoryDaoImpl.class);

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public void save(History history) throws Exception {
		logger.info("badvuru kaydediliyor.");

		try {
			manager.persist(history);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			appLoggerUtils.loggerObj(history, Application.class);
		}

		logger.info("BAsvuru kaydedildi. ID:" + history.getId());
	}

	@Override
	@Transactional
	public void update(History history) throws Exception {
		logger.info("badvuru guncelleniyor.");

		try {
			manager.merge(history);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			appLoggerUtils.loggerObj(history, Application.class);
		}

		logger.info("BAsvuru kaydedildi. ID:" + history.getId());
	}

}
