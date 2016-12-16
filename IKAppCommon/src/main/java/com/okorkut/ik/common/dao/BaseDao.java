package com.okorkut.ik.common.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.log4j.Logger;

public class BaseDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private static EntityManagerFactory FACTORY =
	// Persistence.createEntityManagerFactory("IKAppCommon");

	private EntityManagerFactory entityManagerFactory;

	@PersistenceUnit
	public void setEntityManagerFactory(final EntityManagerFactory emf) {
		entityManagerFactory = emf;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	protected Logger logger = null;

	public BaseDao() {
		logger = Logger.getLogger(this.getClass().getName());
	}

	public EntityManager openConnection() {
		if (entityManagerFactory == null) {
			throw new RuntimeException(
					"The EntityManagerFactory is null.  This must be passed in to the constructor or set using the setEntityManagerFactory() method.");
		}

		final EntityManager em = entityManagerFactory.createEntityManager();
		if (em != null) {
			return em;
		}
		return null;
	}

	public void closeConnection(final EntityManager em) {
		try {
			if (em != null && em.isOpen()) {
				rollbackTransaction(em);
				em.close();
			}
		} catch (final Exception e) {
			logger.error(e, e);
		}

	}

	public EntityManager openTransactionalConnection() {
		final EntityManager em = openConnection();
		if (em != null && em.isOpen()) {
			em.getTransaction().begin();
			return em;
		}
		return null;
	}

	public void startTransaction(final EntityManager em) {
		if (em != null && em.isOpen() && !em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
	}

	public void commitTransaction(final EntityManager em) {
		if (em != null && em.isOpen() && em.getTransaction().isActive()) {
			em.getTransaction().commit();
		}

	}

	public void rollbackTransaction(final EntityManager em) {
		try {
			if (em != null && em.isOpen() && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} catch (final Exception e) {
			logger.error(e, e);
		}
	}

	public String hibernateClobConverterToString(final Object object) throws Exception {
		/*
		 * DB2 have some issue Solution : db2set DB2_RESTRICT_DDF=true
		 * http://www.ibm.com/developerworks/forums/thread.jspa?threadID=268395
		 */
		logger.debug("Treasury Service Bus DAO Base JPA - hibernateClobConverterToString start.");
		if (object != null) {
			java.sql.Clob clob;
			clob = (java.sql.Clob) object;
			if ((int) clob.length() > 0) {
				return clob.getSubString(1, (int) clob.length());
			}
		}
		return "";
	}

}
