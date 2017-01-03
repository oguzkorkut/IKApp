package com.okorkut.ik.service;

import java.util.List;

import com.okorkut.ik.common.entity.History;
import com.okorkut.ik.dto.HistoryDto;

public interface HistoryService {

	public void save(HistoryDto historyDto) throws Exception;

	public void saveCollection(List<HistoryDto> historyDtos) throws Exception;

	public List<History> getHistoriesByApplicationDto(List<HistoryDto> historyDtos) throws Exception;

	public void addHistory(Integer userId, Integer applicationId) throws Exception;

}
