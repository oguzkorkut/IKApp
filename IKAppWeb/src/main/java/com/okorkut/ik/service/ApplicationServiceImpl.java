package com.okorkut.ik.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.dao.ApplicationDao;
import com.okorkut.ik.common.entity.Application;
import com.okorkut.ik.dto.ApplicationDto;

public class ApplicationServiceImpl implements ApplicationService {

	private static final Logger logger = Logger.getLogger(ApplicationServiceImpl.class);

	@Autowired
	private ApplicationDao applicationDao;

	public ApplicationServiceImpl() {
	}

	@Override
	@Transactional
	public void save(ApplicationDto applicationDto) throws Exception {

	}

	@Override
	@Transactional
	public void saveCollection(List<ApplicationDto> applicationDtos) throws Exception {

		List<Application> applications = getApplicationByApplicationDto(applicationDtos);

		if (!CollectionUtils.isEmpty(applications)) {

		}
	}

	@Override
	public List<Application> getApplicationByApplicationDto(List<ApplicationDto> applicationDtos) throws Exception {

		if (CollectionUtils.isEmpty(applicationDtos)) {
			return null;
		}
		List<Application> applications = new ArrayList<Application>();

		Application application = null;

		for (int i = 0; i < applicationDtos.size(); i++) {
			application = new Application();
			BeanUtils.copyProperties(applicationDtos.get(i), application);
			applications.add(application);
		}

		return applications;
	}

	@Override
	@Transactional
	public void addApplicaiton(Integer userId, Integer positionId) throws Exception {

		Application application = new Application();

		application.setActive(true);
		application.setApplicationDate(new Date());
		application.setUserId(userId);
		application.setPositionId(positionId);

		applicationDao.save(application);

		logger.info("Basvuru alindi. Basvuru Id:" + application.getId());
	}

}
