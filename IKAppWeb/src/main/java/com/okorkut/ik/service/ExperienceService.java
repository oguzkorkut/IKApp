package com.okorkut.ik.service;

import java.util.List;

import com.okorkut.ik.common.entity.Experience;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.ExperienceDto;

public interface ExperienceService {

	public void save(ExperienceDto experienceDto) throws Exception;

	public void update(ExperienceDto experienceDto) throws Exception;

	public void saveCollection(User user, List<ExperienceDto> experienceDtos) throws Exception;

	public List<Experience> getExperienceByExperienceDto(List<ExperienceDto> experienceDtos) throws Exception;

	public List<ExperienceDto> getExperienceDtosByExperienceList(List<Experience> experienceList) throws Exception;

}
