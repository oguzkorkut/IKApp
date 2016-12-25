package com.okorkut.ik.service;

import java.util.List;

import com.okorkut.ik.common.entity.Education;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.EducationDto;

public interface EducationService {

	public void save(EducationDto educationDto) throws Exception;

	public void update(EducationDto educationDto) throws Exception;

	public void saveCollection(User user, List<EducationDto> educationDtos) throws Exception;

	public List<Education> getEducationByEducationDto(List<EducationDto> educationDtos) throws Exception;

	public List<EducationDto> getEducationDtosByEducationList(List<Education> educationList) throws Exception;

}
