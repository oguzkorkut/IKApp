package com.okorkut.ik.service;

import java.util.List;

import com.okorkut.ik.common.entity.Certificate;
import com.okorkut.ik.common.entity.User;
import com.okorkut.ik.dto.CertificateDto;

public interface CertificateService {

	public void save(CertificateDto certificateDto) throws Exception;

	public void update(CertificateDto certificateDto) throws Exception;

	public void saveCollection(User user, List<CertificateDto> certificateDtos) throws Exception;

	public List<Certificate> getCertificateByCertificateDto(List<CertificateDto> certificateDtos) throws Exception;

	public List<CertificateDto> getCertificateDtoByCertificateList(List<Certificate> certificateList) throws Exception;

}
