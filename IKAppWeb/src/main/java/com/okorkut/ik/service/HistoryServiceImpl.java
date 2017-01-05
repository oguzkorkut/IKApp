package com.okorkut.ik.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.dao.HistoryDao;
import com.okorkut.ik.common.entity.History;
import com.okorkut.ik.dto.HistoryDto;
import com.okorkut.ik.dto.MessageDto;
import com.okorkut.ik.enums.ActionEnum;

public class HistoryServiceImpl implements HistoryService {

	private static final Logger logger = Logger.getLogger(HistoryServiceImpl.class);

	@Autowired
	private HistoryDao historyDao;

	public HistoryServiceImpl() {
	}

	@Override
	@Transactional
	public void save(HistoryDto historyDto) throws Exception {

	}

	@Override
	@Transactional
	public void saveCollection(List<HistoryDto> historyDtos) throws Exception {

		List<History> histories = getHistoriesByApplicationDto(historyDtos);

		if (!CollectionUtils.isEmpty(histories)) {

		}
	}

	@Override
	public List<History> getHistoriesByApplicationDto(List<HistoryDto> historyDtos) throws Exception {

		if (CollectionUtils.isEmpty(historyDtos)) {
			return null;
		}
		List<History> histories = new ArrayList<History>();

		History history = null;

		for (int i = 0; i < historyDtos.size(); i++) {
			history = new History();
			BeanUtils.copyProperties(historyDtos.get(i), history);
			histories.add(history);
		}

		return histories;
	}

	@Override
	@Transactional
	public void addHistory(Integer userId, Integer applicationId) throws Exception {

		History history = new History();

		history.setActive(true);
		history.setApplicationId(applicationId);
		history.setTaskAssignDate(new Date());
		history.setUserAction(ActionEnum.APPLICATION.getValue());

		historyDao.save(history);

		logger.info("Basvuru alindi. Basvuru Id:" + history.getId());
	}

	@Override
	public HistoryDto getHistoryById(Integer id) throws Exception {
		HistoryDto historyDto = new HistoryDto();

		History history = historyDao.getHistoryById(id);

		BeanUtils.copyProperties(history, historyDto);

		return historyDto;
	}

	@Override
	public void update(HistoryDto historyDto) throws Exception {
		History history = new History();

		BeanUtils.copyProperties(historyDto, history);

		historyDao.update(history);
	}

	@Override
	public List<MessageDto> getMessagesDtosById(Integer id) throws Exception {

		List<MessageDto> messageDtos = new ArrayList<MessageDto>();

		List<History> histories = historyDao.getMessagesById(id);

		MessageDto messageDto = null;

		for (int i = 0; i < histories.size(); i++) {

			messageDto = new MessageDto();
			
			messageDto.setComment(histories.get(i).getUserComment());
			messageDto.setResult(ActionEnum.getValueByCode(histories.get(i).getUserAction()));
			messageDto.setTaskCompletionDate(histories.get(i).getTaskAssignDate());
			messageDto.setPozisyon(histories.get(i).getApplication().getPosition().getName());

			messageDtos.add(messageDto);

		}

		return messageDtos;
	}

}
