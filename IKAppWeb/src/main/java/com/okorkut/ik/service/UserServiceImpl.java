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
import com.okorkut.ik.common.dao.PositionDao;
import com.okorkut.ik.common.dao.RoleDao;
import com.okorkut.ik.common.dao.UserDao;
import com.okorkut.ik.common.entity.History;
import com.okorkut.ik.common.entity.Position;
import com.okorkut.ik.common.entity.Profile;
import com.okorkut.ik.common.entity.Role;
import com.okorkut.ik.common.entity.RoleGroup;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.HistoryDto;
import com.okorkut.ik.dto.MessageDto;
import com.okorkut.ik.dto.PositionDto;
import com.okorkut.ik.dto.ProfileDto;
import com.okorkut.ik.dto.ResultDto;
import com.okorkut.ik.dto.RoleDto;
import com.okorkut.ik.dto.RoleGroupDto;
import com.okorkut.ik.dto.UserDto;
import com.okorkut.ik.enums.ActionEnum;

public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	public RoleDao roleDao;

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private CertificateService certificateService;

	@Autowired
	private EducationService educationService;

	@Autowired
	private ExperienceService experienceService;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private ReferenceService referenceService;

	@Autowired
	private PositionDao positionDao;

	@Autowired
	private HistoryDao historyDao;

	@Autowired
	private HistoryService historyService;

	public UserServiceImpl() {
	}

	/**
	 * Eposta ve sifre kullanilarak musteri dondurulur.
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserDto getUserByEmailAndPassword(String email, String password) throws Exception {
		UserDto userDto = new UserDto();

		User user = userDao.getUserByEmailAndPassword(email, password);

		if (user != null) {
			BeanUtils.copyProperties(user, userDto);

			List<RoleGroup> roleGroups = user.getRoleGroups();

			List<String> roles = new ArrayList<String>();
			for (int i = 0; i < roleGroups.size(); i++) {
				roles.add(roleGroups.get(i).getRole().getRoleName());
			}

			userDto.setRoleDtos(roles);

		} else {
			return null;
		}
		return userDto;
	}

	@Override
	@Transactional
	public void save(UserDto userDto) throws Exception {

		User user = new User();

		if (userDto != null) {
			BeanUtils.copyProperties(userDto, user);

			user.setProfile(getProfileByProfileDto(userDto.getProfileDto()));

			userDao.save(user);

			certificateService.saveCollection(user, userDto.getCertificateDtos());

			educationService.saveCollection(user, userDto.getEducationDtos());

			experienceService.saveCollection(user, userDto.getExperienceDtos());

			languageService.saveCollection(user, userDto.getLanguageDtos());

			referenceService.saveCollection(user, userDto.getReferenceDtos());

			// Personel role cekiliyor
			// Role role = roleDao.getRoleById(3);

			RoleGroup roleGroup = new RoleGroup();

			roleGroup.setActive(true);
			// roleGroup.setRole(role);
			// roleGroup.setUser(user);
			roleGroup.setUserId(user.getId());
			roleGroup.setRoleId(3);

			List<RoleGroup> roleGroups = new ArrayList<RoleGroup>();
			roleGroups.add(roleGroup);
			saveRoleGroups(roleGroups);

			logger.info("Musteri kaydedildi. Id:" + user.getId());
		}

	}

	@Transactional
	private void saveRoleGroups(List<RoleGroup> groups) throws Exception {
		if (!CollectionUtils.isEmpty(groups)) {
			for (int i = 0; i < groups.size(); i++) {
				roleDao.save(groups.get(i));
			}
		}
	}

	@Override
	public RoleDto getRoleDtoById(Integer id) throws Exception {

		RoleDto roleDto = null;

		Role role = roleDao.getRoleById(id);

		roleDto = new RoleDto();

		BeanUtils.copyProperties(role, roleDto);

		return roleDto;
	}

	private Profile getProfileByProfileDto(ProfileDto profileDto) throws Exception {

		Profile profile = new Profile();

		if (profileDto != null) {
			BeanUtils.copyProperties(profileDto, profile);
		} else {
			return null;
		}

		return profile;
	}

	@Override
	public List<PositionDto> getPositions() throws Exception {
		List<PositionDto> positionDtos = new ArrayList<PositionDto>();

		List<Position> positions = positionDao.getPositions();

		if (CollectionUtils.isEmpty(positions)) {
			return null;
		}

		PositionDto positionDto = null;

		for (int i = 0; i < positions.size(); i++) {

			positionDto = new PositionDto();

			BeanUtils.copyProperties(positions.get(i), positionDto);

			positionDtos.add(positionDto);

		}

		return positionDtos;
	}

	@Override
	public List<PositionDto> getPositionsByUserId(Integer userId) throws Exception {
		List<PositionDto> positionDtos = new ArrayList<PositionDto>();

		List<Position> positions = positionDao.getPositionsByUserId(userId);

		if (CollectionUtils.isEmpty(positions)) {
			return null;
		}

		PositionDto positionDto = null;

		for (int i = 0; i < positions.size(); i++) {

			positionDto = new PositionDto();

			BeanUtils.copyProperties(positions.get(i), positionDto);

			positionDtos.add(positionDto);

		}

		return positionDtos;
	}

	@Override
	@Transactional
	public PositionDto addPosition(PositionDto positionDto) throws Exception {

		Position position = new Position();

		BeanUtils.copyProperties(positionDto, position);

		positionDao.add(position);

		PositionDto newPositionDto = new PositionDto();

		BeanUtils.copyProperties(position, newPositionDto);
		return newPositionDto;
	}

	@Override
	@Transactional
	public boolean updatePosition(PositionDto positionDto) throws Exception {

		Position position = new Position();

		BeanUtils.copyProperties(positionDto, position);

		positionDao.update(position);

		return true;
	}

	@Override
	@Transactional
	public boolean deletePosition(Integer id) throws Exception {

		return positionDao.delete(id);
	}

	@Override
	@Transactional
	public void applyPositionByPositionId(Integer userId, Integer positionId) throws Exception {
		applicationService.addApplicaiton(userId, positionId);
	}

	@Override
	public UserDto getUserProfileById(Integer id) throws Exception {
		UserDto userDto = new UserDto();

		User user = userDao.getUserById(id);

		if (user != null) {
			BeanUtils.copyProperties(user, userDto);

			if (user.getProfile() != null) {
				ProfileDto profileDto = new ProfileDto();
				BeanUtils.copyProperties(user.getProfile(), profileDto);

				userDto.setProfileDto(profileDto);
			}

			userDto.setCertificateDtos(certificateService.getCertificateDtoByCertificateList(user.getCertificates()));

			userDto.setEducationDtos(educationService.getEducationDtosByEducationList(user.getEducations()));

			userDto.setExperienceDtos(experienceService.getExperienceDtosByExperienceList(user.getExperiences()));

			userDto.setLanguageDtos(languageService.getLanguageDtosByLanguageList(user.getLanguages()));

			userDto.setReferenceDtos(referenceService.getReferenceDtosByReferenceList(user.getReferences()));

			userDto.setRoleDtos(getRolesByRoleGroupList(user.getRoleGroups()));

		} else {
			return null;
		}
		return userDto;
	}

	private List<String> getRolesByRoleGroupList(List<RoleGroup> roleGroupList) throws Exception {

		List<String> roleDtos = new ArrayList<String>();

		// RoleDto roleDto = null;

		if (CollectionUtils.isEmpty(roleGroupList)) {
			return roleDtos;
		} else {
			for (int i = 0; i < roleGroupList.size(); i++) {
				// roleDto = new RoleDto();
				// BeanUtils.copyProperties(roleGroupList.get(i).getRole(), roleDto);
				// roleDtos.add(roleDto);
				roleDtos.add(roleGroupList.get(i).getRole().getRoleName());
			}
		}

		return roleDtos;
	}

	private List<RoleGroup> getRoleGroupByRoleGroupDto(List<RoleGroupDto> roleGroupDtos) throws Exception {

		List<RoleGroup> groups = new ArrayList<RoleGroup>();

		RoleGroup roleGroup = null;

		if (CollectionUtils.isEmpty(roleGroupDtos)) {
			return null;
		} else {
			for (int i = 0; i < roleGroupDtos.size(); i++) {
				roleGroup = new RoleGroup();
				BeanUtils.copyProperties(roleGroupDtos.get(i), roleGroup);
				groups.add(roleGroup);
			}
		}

		return groups;
	}

	@Override
	public List<HistoryDto> getTasksByRoles(List<String> roles) throws Exception {

		List<History> histories = historyDao.getTasksByRoles(roles);

		List<HistoryDto> historyDtos = null;

		if (!CollectionUtils.isEmpty(histories)) {
			historyDtos = new ArrayList<HistoryDto>();

			HistoryDto historyDto = null;

			for (int i = 0; i < histories.size(); i++) {
				historyDto = new HistoryDto();

				BeanUtils.copyProperties(histories.get(i), historyDto);

				historyDto.setUserName(histories.get(i).getApplication().getUser().getName() + " " + histories.get(i).getApplication().getUser().getLastname());
				historyDto.setPosition(histories.get(i).getApplication().getPosition().getName());
				historyDto.setApplierId(histories.get(i).getApplication().getUser().getId());

				historyDtos.add(historyDto);
			}
		}

		return historyDtos;
	}

	@Override
	public void decision(ResultDto resultDto, Integer approverId) throws Exception {
		HistoryDto historyDto = historyService.getHistoryById(resultDto.getHistoryId());

		if (resultDto.isResult()) {
			historyDto.setUserId(approverId);
			historyDto.setTaskAssignDate(new Date());
			if (historyDto.getUserAction().equalsIgnoreCase(ActionEnum.APPLICATION.getCode())) {
				historyDto.setUserAction(ActionEnum.APPROVE_IK.getCode());
				historyDto.setRoleId(1);
			} else if (historyDto.getUserAction().equalsIgnoreCase(ActionEnum.APPROVE_IK.getCode())) {
				historyDto.setUserAction(ActionEnum.APPROVE_MANAGER.getCode());
				historyDto.setRoleId(3);
			} else if (historyDto.getUserAction().equalsIgnoreCase(ActionEnum.APPROVE_MANAGER.getCode())) {
				historyDto.setUserAction(ActionEnum.APPROVE.getCode());
				historyDto.setRoleId(3);
			}
		} else {
			historyDto.setUserAction(ActionEnum.REJECT.getCode());
			historyDto.setUserComment(resultDto.getComment());
			historyDto.setRoleId(3);
			historyDto.setActive(false);
		}

		historyService.update(historyDto);
	}

	@Override
	public List<MessageDto> getMessagesDtosById(Integer id) throws Exception {

		List<MessageDto> messageDtos = historyService.getMessagesDtosById(id);

		return messageDtos;
	}

}
