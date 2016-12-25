package com.okorkut.ik.common.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.entity.Position;
import com.okorkut.ik.common.utils.IKAppLoggerUtils;

@Repository("positionDaoImpl")
public class PositionDaoImpl extends BaseDao implements PositionDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PositionDaoImpl.class);

	@Autowired
	private IKAppLoggerUtils appLoggerUtils;

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public Position add(Position position) throws Exception {
		logger.info("Pozisyon kaydediliyor.");

		try {
			manager.persist(position);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		logger.info("Pozisyon kaydi bitti. ID:" + position.getId());
		return position;
	}

	@Override
	@Transactional
	public boolean update(Position position) throws Exception {
		logger.info("Pozisyon guncelleniyor.");

		try {
			manager.merge(position);

		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		logger.info("Pozisyon guncellendi. ID:" + position.getId());
		return true;
	}

	@Override
	public List<Position> getPositions() throws Exception {
		logger.info("getPositions basladi.");

		List<Position> list = null;

		try {

			Query query = manager.createQuery("SELECT p FROM Position p");
			list = query.getResultList();

			//
			// query = em.createQuery("SELECT d FROM User d");
			// List<User> dList = (List<User>) query.getResultList();

		} catch (NoResultException nre) {
			logger.info("Pozisyon bulunamadi.");
		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		if (!CollectionUtils.isEmpty(list)) {
			appLoggerUtils.loggerObj(list, Position.class);
		}
		logger.info("getPositions bitti.");
		return list;
	}

	/**
	 * Kisinin basvuru yapmamis oldugu basvurularin cekilmesi icin
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Position> getPositionsByUserId(Integer userId) throws Exception {
		logger.info("getPositionsByUserId basladi. User id:" + userId);

		List<Position> positions = null;

		try {

			positions = manager.createNamedQuery("position.findGetPositionsByUserId").setParameter("userId", userId).getResultList();

		} catch (NoResultException nre) {
			logger.info("Pozisyon bulunamadi.");
		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		if (!CollectionUtils.isEmpty(positions)) {
			appLoggerUtils.loggerObj(positions, Position.class);
		}
		logger.info("getPositions bitti.");
		return positions;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) throws Exception {
		logger.info("delete pozisyon. id:" + id);

		try {
			manager.remove(manager.find(Position.class, id));
		} catch (Exception e) {
			logger.error(e, e);
			throw e;
		}

		return true;
	}
}
