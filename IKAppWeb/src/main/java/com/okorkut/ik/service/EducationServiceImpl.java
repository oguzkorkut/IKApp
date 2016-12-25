package com.okorkut.ik.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.dao.EducationDao;
import com.okorkut.ik.common.entity.Education;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.EducationDto;

public class EducationServiceImpl implements EducationService {

	private static final Logger logger = Logger.getLogger(EducationServiceImpl.class);

	@Autowired
	private EducationDao educationDao;

	@Override
	@Transactional
	public void save(EducationDto educationDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void update(EducationDto educationDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void saveCollection(User user, List<EducationDto> educationDtos) throws Exception {
		List<Education> educations = getEducationByEducationDto(educationDtos);

		if (!CollectionUtils.isEmpty(educations)) {
			for (int i = 0; i < educations.size(); i++) {
				// educations.get(i).setUser(user);
				educations.get(i).setUserId(user.getId());

				educationDao.save(educations.get(i));
			}
		}
	}

	@Override
	public List<Education> getEducationByEducationDto(List<EducationDto> educationDtos) throws Exception {

		if (CollectionUtils.isEmpty(educationDtos)) {
			return null;
		}

		List<Education> educations = new ArrayList<Education>();

		Education education = null;

		for (int i = 0; i < educationDtos.size(); i++) {
			education = new Education();
			BeanUtils.copyProperties(educationDtos.get(i), education);
			educations.add(education);
		}

		return educations;
	}

	@Override
	public List<EducationDto> getEducationDtosByEducationList(List<Education> educationList) throws Exception {

		if (CollectionUtils.isEmpty(educationList)) {
			return null;
		}

		List<EducationDto> educationDtos = new ArrayList<EducationDto>();

		EducationDto educationDto = null;
		for (int i = 0; i < educationList.size(); i++) {
			educationDto = new EducationDto();
			BeanUtils.copyProperties(educationList.get(i), educationDto);

			educationDtos.add(educationDto);
		}

		return educationDtos;
	}
}
