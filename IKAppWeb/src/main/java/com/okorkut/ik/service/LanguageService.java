package com.okorkut.ik.service;

import java.util.List;

import com.okorkut.ik.common.entity.Language;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.LanguageDto;

public interface LanguageService {

	public void save(LanguageDto languageDto) throws Exception;

	public void update(LanguageDto languageDto) throws Exception;

	public void saveCollection(User user, List<LanguageDto> languageDtos) throws Exception;

	public List<Language> getLanguageByLanguageDto(List<LanguageDto> languageDtos) throws Exception;

}
