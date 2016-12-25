package com.okorkut.ik.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDao implements UserDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	// @Autowired
	// private SessionFactory sessionFactory;

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public User save(User user) throws Exception {
		logger.info("User save basladi.");

		try {
			manager.persist(user);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		logger.info("User save bitti. ID:" + user.getId());
		return user;
	}

	@Override
	public User getUserDtoByEmail(String emial) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save2(User userDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserDtoByEmail2(String emial) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) throws Exception {
		logger.info("getUserByEmailAndPassword basladi. EMail:" + email);

		User user = null;

		EntityManager em = null;

		// String qlString = "SELECT p FROM Podcast p WHERE p.id = ?1";
		// TypedQuery<Podcast> query = entityManager.createQuery(qlString,
		// Podcast.class);
		// query.setParameter(1, id);

		try {
			// em = openTransactionalConnection();
			user = (User) manager.createNamedQuery("User.findGetUserByEmailAndPassword").setParameter("email", email).setParameter("password", password)
					.getSingleResult();

			// return em.createQuery("SELECT p FROM Product p").getResultList();

			// Query query = em.createQuery("SELECT e FROM User e");
			// List<User> list = (List<User>) query.getResultList();
			//
			// query = em.createQuery("SELECT d FROM User d");
			// List<User> dList = (List<User>) query.getResultList();

		} catch (NoResultException nre) {
			logger.info("Sonuc bulunamadi. email:" + email + " Detay Mesaj:" + nre.getMessage());
		} catch (Exception e) {
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
