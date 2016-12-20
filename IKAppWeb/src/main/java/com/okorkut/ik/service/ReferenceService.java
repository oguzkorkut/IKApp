package com.okorkut.ik.service;

import java.util.List;

import com.okorkut.ik.common.entity.Reference;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.ReferenceDto;

public interface ReferenceService {

	public void save(ReferenceDto referenceDto) throws Exception;

	public void update(ReferenceDto referenceDto) throws Exception;

	public void saveCollection(User user, List<ReferenceDto> referenceDtos) throws Exception;

	public List<Reference> getReferenceByReferenceDto(List<ReferenceDto> referenceDtos) throws Exception;

}
