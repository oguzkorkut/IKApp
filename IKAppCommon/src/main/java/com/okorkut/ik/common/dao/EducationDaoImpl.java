package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.common.entity.Education;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("educationDaoImpl")
public class EducationDaoImpl extends BaseDao implements EducationDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(EducationDaoImpl.class);

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public Education save(Education education) throws Exception {
		logger.info("Egitim bilgisi kaydediliyor.");

		try {
			manager.persist(education);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		logger.info("Egitim bilgilerinin kaydi bitti . ID:" + education.getId());
		return education;
	}

}
