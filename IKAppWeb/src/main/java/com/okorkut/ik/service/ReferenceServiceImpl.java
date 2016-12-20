package com.okorkut.ik.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.dao.ReferenceDao;
import com.okorkut.ik.common.entity.Reference;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.ReferenceDto;

public class ReferenceServiceImpl implements ReferenceService {

	private static final Logger logger = Logger.getLogger(ReferenceServiceImpl.class);

	@Autowired
	private ReferenceDao referenceDao;

	@Override
	@Transactional
	public void save(ReferenceDto referenceDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void update(ReferenceDto referenceDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void saveCollection(User user, List<ReferenceDto> referenceDtos) throws Exception {

		List<Reference> references = getReferenceByReferenceDto(referenceDtos);

		if (!CollectionUtils.isEmpty(references)) {
			for (int i = 0; i < references.size(); i++) {
				// references.get(i).setUser(user);

				references.get(i).setUserId(user.getId());

				referenceDao.save(references.get(i));
			}
		}

	}

	@Override
	public List<Reference> getReferenceByReferenceDto(List<ReferenceDto> referenceDtos) throws Exception {

		if (CollectionUtils.isEmpty(referenceDtos)) {
			return null;
		}

		List<Reference> references = new ArrayList<Reference>();

		Reference reference = null;

		for (int i = 0; i < referenceDtos.size(); i++) {
			reference = new Reference();
			BeanUtils.copyProperties(referenceDtos.get(i), reference);
			references.add(reference);
		}

		return references;
	}

}
