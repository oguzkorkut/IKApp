package com.okorkut.ik.service;

import java.io.IOException;

import javax.mail.MessagingException;


public interface MailService {
	boolean sendMail(String emailTo, String emailToName, int mailType, String keyValue, String referansDate, String nickName, String kisiDilCode,
			boolean bpmUser, String sifre) throws  Exception;

	boolean cancelRepresentativeMail(String emailTo, String TC, String userFullName, String company, String langCode) throws Exception;

}
