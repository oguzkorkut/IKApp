package com.okorkut.ik.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.okorkut.ik.common.dao.CertificateDao;
import com.okorkut.ik.common.entity.Certificate;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.CertificateDto;

public class CertificateServiceImpl implements CertificateService {

	private static final Logger logger = Logger.getLogger(CertificateServiceImpl.class);

	@Autowired
	private CertificateDao certificateDao;

	public CertificateServiceImpl() {
	}

	@Override
	@Transactional
	public void save(CertificateDto certificateDto) throws Exception {

	}

	@Override
	@Transactional
	public void update(CertificateDto certificateDto) throws Exception {

	}

	@Override
	@Transactional
	public void saveCollection(User user, List<CertificateDto> certificateDtos) throws Exception {

		List<Certificate> certificates = getCertificateByCertificateDto(certificateDtos);

		if (!CollectionUtils.isEmpty(certificates)) {
			for (int i = 0; i < certificates.size(); i++) {

				// certificates.get(i).setUser(user);

				certificates.get(i).setUserId(user.getId());

				certificateDao.save(certificates.get(i));
			}
		}
	}

	@Override
	public List<Certificate> getCertificateByCertificateDto(List<CertificateDto> certificateDtos) throws Exception {

		if (CollectionUtils.isEmpty(certificateDtos)) {
			return null;
		}

		List<Certificate> certificates = new ArrayList<Certificate>();

		Certificate certificate = null;

		for (int i = 0; i < certificateDtos.size(); i++) {
			certificate = new Certificate();
			BeanUtils.copyProperties(certificateDtos.get(i), certificate);
			certificates.add(certificate);
		}

		return certificates;
	}

	@Override
	public List<CertificateDto> getCertificateDtoByCertificateList(List<Certificate> certificateList) throws Exception {

		if (CollectionUtils.isEmpty(certificateList)) {
			return null;
		}

		List<CertificateDto> certificateDtos = new ArrayList<CertificateDto>();

		CertificateDto certificateDto = null;
		for (int i = 0; i < certificateList.size(); i++) {
			certificateDto = new CertificateDto();
			BeanUtils.copyProperties(certificateList.get(i), certificateDto);

			certificateDtos.add(certificateDto);
		}
		return certificateDtos;
	}

}
