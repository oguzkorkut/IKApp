package com.okorkut.ik.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.dao.ExperienceDao;
import com.okorkut.ik.common.entity.Experience;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.ExperienceDto;

public class ExperienceServiceImpl implements ExperienceService {

	private static final Logger logger = Logger.getLogger(ExperienceServiceImpl.class);

	@Autowired
	private ExperienceDao experienceDao;

	@Override
	@Transactional
	public void save(ExperienceDto experienceDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void update(ExperienceDto experienceDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void saveCollection(User user, List<ExperienceDto> experienceDtos) throws Exception {

		List<Experience> experiences = getExperienceByExperienceDto(experienceDtos);

		if (!CollectionUtils.isEmpty(experiences)) {
			for (int i = 0; i < experiences.size(); i++) {
				// experiences.get(i).setUser(user);

				experiences.get(i).setUserId(user.getId());

				experienceDao.save(experiences.get(i));
			}
		}

	}

	@Override
	public List<Experience> getExperienceByExperienceDto(List<ExperienceDto> experienceDtos) throws Exception {

		if (CollectionUtils.isEmpty(experienceDtos)) {
			return null;
		}

		List<Experience> experiences = new ArrayList<Experience>();

		Experience experience = null;

		for (int i = 0; i < experienceDtos.size(); i++) {
			experience = new Experience();
			BeanUtils.copyProperties(experienceDtos.get(i), experience);
			experiences.add(experience);
		}
		return experiences;
	}

}
