package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDao implements UserDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User save(final User userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserDtoByEmail(final String emial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save2(final User userDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserDtoByEmail2(final String emial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmailAndPassword(final String email, final String password) throws Exception {
		logger.info("getUserByEmailAndPassword basladi. EMail:" + email);

		User user = null;

		EntityManager em = null;

		// String qlString = "SELECT p FROM Podcast p WHERE p.id = ?1";
		// TypedQuery<Podcast> query = entityManager.createQuery(qlString,
		// Podcast.class);
		// query.setParameter(1, id);

		try {
			em = openConnection();
			user = (User) manager.createNamedQuery("User.findGetUserByEmailAndPassword").setParameter("email", email)
					.setParameter("password", password).getSingleResult();

			// return em.createQuery("SELECT p FROM Product p").getResultList();

		} catch (final NoResultException nre) {
			logger.info("Sonuc bulunamadi. email:" + email + " Detay Mesaj:" + nre.getMessage());
		} catch (final Exception e) {
			logger.error(e, e);
		} finally {
			closeConnection(em);
		}

		if (user != null) {
			appLoggerUtils.loggerObj(user, user.getClass());
		}
		logger.info("getUserByEmailAndPassword bitti.");
		return user;
	}

	// @Override
	// public UserDto save(UserDto userDto) {
	// EntityManager em = null;
	// try {
	// em = openTransactionalConnection();
	//
	//// userDto.setCreateDate(new Timestamp(new Date().getTime()));
	//// userDto.setCreatedBy("SA");
	//// userDto.setUpdateDate(new Timestamp(new Date().getTime()));
	//// userDto.setUpdatedBy("SA");
	//// userDto.setUserIpAddress(Inet4Address.getLocalHost().getHostAddress());
	//
	// em.persist(userDto);
	// commitTransaction(em);
	// } catch (Exception ex) {
	// rollbackTransaction(em);
	// logger.error(ex, ex);
	// } finally {
	// closeConnection(em);
	// }
	//
	// logger.debug("AuditLog was inserted with id : " + 1);
	// return userDto;
	// }
	//
	// @Override
	// public UserDto getUserDtoByEmail(String emial) {
	// Session session = this.sessionFactory.openSession();
	// List<User> user = session.createQuery("from user").list();
	// session.close();
	// return null;
	// }
	//
	// @Override
	// public void save2(UserDto userDto) {
	// Session session = this.sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// session.persist(userDto);
	// tx.commit();
	// session.close();
	//
	// }
	//
	// @Override
	// public UserDto getUserDtoByEmail2(String emial) {
	// Session session = this.sessionFactory.openSession();
	// List<User> user = session.createQuery("from user").list();
	// session.close();
	// return null;
	// }

}
