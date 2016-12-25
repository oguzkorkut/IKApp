package com.okorkut.ik.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.dao.PositionDao;
import com.okorkut.ik.common.dao.RoleDao;
import com.okorkut.ik.common.dao.UserDao;
import com.okorkut.ik.common.entity.Position;
import com.okorkut.ik.common.entity.Profile;
import com.okorkut.ik.common.entity.Role;
import com.okorkut.ik.common.entity.RoleGroup;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.PositionDto;
import com.okorkut.ik.dto.ProfileDto;
import com.okorkut.ik.dto.RoleDto;
import com.okorkut.ik.dto.RoleGroupDto;
import com.okorkut.ik.dto.UserDto;

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

}
