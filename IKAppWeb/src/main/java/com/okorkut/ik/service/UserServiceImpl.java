package com.okorkut.ik.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.dao.RoleDao;
import com.okorkut.ik.common.dao.UserDao;
import com.okorkut.ik.common.entity.Application;
import com.okorkut.ik.common.entity.Certificate;
import com.okorkut.ik.common.entity.Education;
import com.okorkut.ik.common.entity.Experience;
import com.okorkut.ik.common.entity.Language;
import com.okorkut.ik.common.entity.Profile;
import com.okorkut.ik.common.entity.Reference;
import com.okorkut.ik.common.entity.Role;
import com.okorkut.ik.common.entity.RoleGroup;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.ApplicationDto;
import com.okorkut.ik.dto.CertificateDto;
import com.okorkut.ik.dto.EducationDto;
import com.okorkut.ik.dto.ExperienceDto;
import com.okorkut.ik.dto.LanguageDto;
import com.okorkut.ik.dto.ProfileDto;
import com.okorkut.ik.dto.ReferenceDto;
import com.okorkut.ik.dto.RoleDto;
import com.okorkut.ik.dto.RoleGroupDto;
import com.okorkut.ik.dto.UserDto;

public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	public RoleDao roleDao;

	public UserServiceImpl() {
	}

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
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

			// user.setApplications(getApplicationByApplicationDto(userDto.getApplicationDtos()));
			user.setCertificates(getCertificateByCertificateDto(userDto.getCertificateDtos()));
			user.setEducations(getEducationByEducationDto(userDto.getEducationDtos()));
			user.setExperiences(getExperienceByExperienceDto(userDto.getExperienceDtos()));
			user.setLanguages(getLanguageByLanguageDto(userDto.getLanguageDtos()));
			user.setProfile(getProfileByProfileDto(userDto.getProfileDto()));
			user.setReferences(getReferenceByReferenceDto(userDto.getReferenceDtos()));

			// group begin
			List<RoleGroupDto> groups = new ArrayList<RoleGroupDto>();

			RoleGroupDto groupDto = new RoleGroupDto();

			// Personel role cekiliyor
			Role role = roleDao.getRoleById(3);

			RoleGroup roleGroup = new RoleGroup();

			roleGroup.setActive(true);
			roleGroup.setRole(role);

			user.addRoleGroup(roleGroup);

			// user.setApplications(null);
			// user.setCertificates(null);
			// user.setEducations(null);
			// user.setExperiences(null);
			// user.setLanguages(null);
			// user.setReferences(null);

			Integer id = userDao.save(user);

			logger.info("Musteri kaydedildi. Id:" + id);
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

	private List<Application> getApplicationByApplicationDto(List<ApplicationDto> applicationDtos) throws Exception {

		List<Application> applications = new ArrayList<Application>();

		Application application = null;

		if (CollectionUtils.isEmpty(applicationDtos)) {
			return null;
		} else {
			for (int i = 0; i < applicationDtos.size(); i++) {
				application = new Application();
				BeanUtils.copyProperties(applicationDtos.get(i), application);
				applications.add(application);
			}
		}

		return applications;
	}

	private List<Education> getEducationByEducationDto(List<EducationDto> educationDtos) throws Exception {

		List<Education> educations = new ArrayList<Education>();

		Education education = null;

		if (CollectionUtils.isEmpty(educationDtos)) {
			return null;
		} else {
			for (int i = 0; i < educationDtos.size(); i++) {
				education = new Education();
				BeanUtils.copyProperties(educationDtos.get(i), education);
				educations.add(education);
			}
		}

		return educations;
	}

	private List<Experience> getExperienceByExperienceDto(List<ExperienceDto> experienceDtos) throws Exception {

		List<Experience> experiences = new ArrayList<Experience>();

		Experience experience = null;

		if (CollectionUtils.isEmpty(experienceDtos)) {
			return null;
		} else {
			for (int i = 0; i < experienceDtos.size(); i++) {
				experience = new Experience();
				BeanUtils.copyProperties(experienceDtos.get(i), experience);
				experiences.add(experience);
			}
		}
		return experiences;
	}

	private List<Certificate> getCertificateByCertificateDto(List<CertificateDto> certificateDtos) throws Exception {

		List<Certificate> certificates = new ArrayList<Certificate>();

		Certificate certificate = null;

		if (CollectionUtils.isEmpty(certificateDtos)) {
			return null;
		} else {
			for (int i = 0; i < certificateDtos.size(); i++) {
				certificate = new Certificate();
				BeanUtils.copyProperties(certificateDtos.get(i), certificate);
				certificates.add(certificate);
			}
		}

		return certificates;
	}

	private List<Language> getLanguageByLanguageDto(List<LanguageDto> languageDtos) throws Exception {

		List<Language> languages = new ArrayList<Language>();

		Language language = null;

		if (CollectionUtils.isEmpty(languageDtos)) {
			return null;
		} else {
			for (int i = 0; i < languageDtos.size(); i++) {
				language = new Language();
				BeanUtils.copyProperties(languageDtos.get(i), language);
				languages.add(language);
			}
		}

		return languages;
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

	private List<Reference> getReferenceByReferenceDto(List<ReferenceDto> referenceDtos) throws Exception {

		List<Reference> references = new ArrayList<Reference>();

		Reference reference = null;

		if (CollectionUtils.isEmpty(referenceDtos)) {
			return null;
		} else {
			for (int i = 0; i < referenceDtos.size(); i++) {
				reference = new Reference();
				BeanUtils.copyProperties(referenceDtos.get(i), reference);
				references.add(reference);
			}
		}

		return references;
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

}
