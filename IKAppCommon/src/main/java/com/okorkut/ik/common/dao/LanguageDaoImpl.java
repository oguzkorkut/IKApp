package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.common.entity.Language;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("languageDaoImpl")
public class LanguageDaoImpl extends BaseDao implements LanguageDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(LanguageDaoImpl.class);

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public Language save(Language language) throws Exception {
		logger.info("Dil bilgileri kaydediliyor.");

		try {
			manager.persist(language);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		logger.info("Dil bilgileri kaydi bitti . ID:" + language.getId());
		return language;
	}

}
