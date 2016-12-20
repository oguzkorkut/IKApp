package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.common.entity.Reference;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("referenceDaoImpl")
public class ReferenceDaoImpl extends BaseDao implements ReferenceDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ReferenceDaoImpl.class);

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public Reference save(Reference reference) throws Exception {
		logger.info("Referans bilgileri kaydediliyor.");

		try {
			manager.persist(reference);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		logger.info("Referans bilgileri kaydi bitti . ID:" + reference.getId());
		return reference;
	}

}
