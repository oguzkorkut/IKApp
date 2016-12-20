package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.common.entity.Experience;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("experienceDaoImpl")
public class ExperienceDaoImpl extends BaseDao implements ExperienceDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ExperienceDaoImpl.class);

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public Experience save(Experience experience) throws Exception {
		logger.info("Is deyimleri kaydediliyor.");

		try {
			manager.persist(experience);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		logger.info("Is deneyimlerinin kaydi bitti . ID:" + experience.getId());
		return experience;
	}

}
