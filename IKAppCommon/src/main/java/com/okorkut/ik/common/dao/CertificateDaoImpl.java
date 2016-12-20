package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.common.entity.Certificate;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("certificateDaoImpl")
public class CertificateDaoImpl extends BaseDao implements CertificateDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(CertificateDaoImpl.class);

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public Certificate save(Certificate certificate) throws Exception {
		logger.info("Sertifikalar kaydediliyor.");

		try {
			manager.persist(certificate);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		logger.info("Sertifika kaydi bitti . ID:" + certificate.getId());
		return certificate;
	}

}
