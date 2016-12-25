package com.okorkut.ik.service;

import java.util.List;

import com.okorkut.ik.common.entity.Application;
import com.okorkut.ik.dto.ApplicationDto;

public interface ApplicationService {

	public void save(ApplicationDto applicationDto) throws Exception;

	public void saveCollection(List<ApplicationDto> applicationDtos) throws Exception;

	public List<Application> getApplicationByApplicationDto(List<ApplicationDto> applicationDtos) throws Exception;

	public void addApplicaiton(Integer userId, Integer positionId) throws Exception;

}
