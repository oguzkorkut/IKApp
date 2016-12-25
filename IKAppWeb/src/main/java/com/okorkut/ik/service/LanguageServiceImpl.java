package com.okorkut.ik.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.dao.LanguageDao;
import com.okorkut.ik.common.entity.Language;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.LanguageDto;

public class LanguageServiceImpl implements LanguageService {

	private static final Logger logger = Logger.getLogger(LanguageServiceImpl.class);

	@Autowired
	private LanguageDao languageDao;

	@Override
	@Transactional
	public void save(LanguageDto languageDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void update(LanguageDto languageDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void saveCollection(User user, List<LanguageDto> languageDtos) throws Exception {

		List<Language> languages = getLanguageByLanguageDto(languageDtos);

		if (!CollectionUtils.isEmpty(languages)) {
			for (int i = 0; i < languages.size(); i++) {
				// languages.get(i).setUser(user);

				languages.get(i).setUserId(user.getId());

				languageDao.save(languages.get(i));
			}
		}

	}

	@Override
	public List<Language> getLanguageByLanguageDto(List<LanguageDto> languageDtos) throws Exception {

		if (CollectionUtils.isEmpty(languageDtos)) {
			return null;
		}

		List<Language> languages = new ArrayList<Language>();

		Language language = null;

		for (int i = 0; i < languageDtos.size(); i++) {
			language = new Language();
			BeanUtils.copyProperties(languageDtos.get(i), language);
			languages.add(language);
		}

		return languages;
	}

	@Override
	public List<LanguageDto> getLanguageDtosByLanguageList(List<Language> languageList) throws Exception {

		if (CollectionUtils.isEmpty(languageList)) {
			return null;
		}

		List<LanguageDto> languageDtos = new ArrayList<LanguageDto>();

		LanguageDto languageDto = null;

		for (int i = 0; i < languageList.size(); i++) {
			languageDto = new LanguageDto();
			BeanUtils.copyProperties(languageList.get(i), languageDto);
			languageDtos.add(languageDto);
		}

		return languageDtos;
	}

}
