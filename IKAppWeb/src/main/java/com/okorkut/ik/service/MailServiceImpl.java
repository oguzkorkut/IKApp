package com.okorkut.ik.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.okorkut.ik.enums.ContentTypeEnum;


public class MailServiceImpl implements MailService {

	private static final Logger logger = Logger.getLogger(MailServiceImpl.class);

	private JavaMailSenderImpl mailSender;

	private VelocityEngine velocityEngine;

	private String from;
	private String encoding;
	private String context;

	// public Properties PROPMailContent = new Properties();

	public String tseServiceLink;
	public String tseLink;

	public String tseActivationGreetings;
	public String tseActivationSubject;
	public String tseActivationTo;
	public String tseActivationBody;
	public String tseActivationLink;
	public String tseActivationFootnoot;

	public String tsePasswordGreetings;
	public String tsePasswordSubject;
	public String tsePasswordBody;
	public String tsePasswordLink;
	public String tsePasswordFootnoot;

	public String tseCompanyRepresentativeGreetings;
	public String tseCompanyRepresentativeSubject;
	public String tseCompanyRepresentativeBody;
	public String tseCompanyRepresentativeLink;
	public String tseCompanyRepresentativeFootnoot;

	private static ApplicationContext appContext = null;

	private static MailService mailService = null;

	public MailServiceImpl() {
	}

	public static MailService getInstance() {
		if (mailService != null) {
			return mailService;
		}

		appContext = new ClassPathXmlApplicationContext("classpath:Spring/Spring-Mail.xml");
		mailService = (MailServiceImpl) appContext.getBean("mailService");

		return mailService;
	}

	public MailServiceImpl(JavaMailSenderImpl mailSender) {
		super();
		this.mailSender = mailSender;
	}

	@Override
	public boolean sendMail(String emailTo, String emailToName, int mailType, String linkValue, String referansDate, String nickName, String langCode,
			boolean bpmUser, String sifre) throws Exception {
		logger.info("sendMail basladi. emailTo:" + emailTo + " emailToName:" + emailToName + " mailType:" + mailType + " linkValue:" + linkValue
				+ " referansDate" + referansDate + " nickName:" + nickName + " langCode:" + langCode);
		logger.info("sending mail in mail type : " + mailType);

		try {

			fillMailFieldByProperityFile(langCode);
			// org.springframework.mail.SimpleMailMessage message = new org.springframework.mail.SimpleMailMessage();
			// message.setFrom(from);
			// message.setTo("oguzkrkt@gmail.com");
			// message.setSubject("test");
			// message.setText("deneme");
			// mailSender.send(message);

			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart messageMultipart = new MimeMultipart();

			String contentType = ContentTypeEnum.HTML_CONTENT_TYPE.getContentType();

			if (StringUtils.isBlank(contentType)) {
				contentType = ContentTypeEnum.TEXT_CONTENT_TYPE.getContentType();
			}
			contentType += "; charset=UTF-8";
			String body = getHtmlContent(mailType, emailToName, linkValue, referansDate, nickName, "", "", "");

			if (bpmUser) {
				body = body.replace("$adsifre", "Giriş için kullanıcı adı: " + nickName + " geçici şifre:" + sifre + " ");
			} else {
				body = body.replace("$adsifre", "");
			}

			messageBodyPart.setText(body, encoding);
			messageBodyPart.setHeader("Content-type", contentType);
			messageMultipart.addBodyPart(messageBodyPart);
			mimeMessage.setContent(messageMultipart);

			if (mailType == 1) {// Activation
				mimeMessage.setSubject(tseActivationSubject, "UTF-8");
			} else if (mailType == 2) {// Password
				mimeMessage.setSubject(tsePasswordSubject, "UTF-8");
			}
			mimeMessage.setFrom(new InternetAddress(from));

			if (StringUtils.isBlank(emailTo)) {
				throw new Exception("Email TO information has not been set!");
			}

			mimeMessage.setRecipients(Message.RecipientType.TO, emailTo);

			mailSender.send(mimeMessage);

			logger.info("html mail sent to " + emailTo);
		} catch (Exception e) {
			logger.error(e, e);
			logger.fatal("Mail Gonderimi Sirasinda Bir Hata olustu Hata:" + e);
			throw e;
		}
		logger.info("sendMail bitti.");
		return true;
	}

	/**
	 * Prepare Greetings, Body, Trailer, Signature and Copyright
	 * 
	 * @param emailType
	 * @param wcscr
	 * @param userComment
	 * @return
	 */
	private String getHtmlContent(int mailType, String emailToName, String link, String referansDate, String nickName, String TC, String fullName,
			String firma) {
		logger.info("getHtmlContent basladi. mailType:" + mailType + " emailToName:" + emailToName + " link:" + link + " referansDate:" + referansDate
				+ " nickName:" + nickName);
		String greetings = "";
		String body = "";
		String footnoot = "";
		String header = "";
		String htmlPath = "";
		if (mailType == 1) {// Activation
			greetings = tseActivationGreetings;// + " " + emailToName;
			body = tseActivationBody + "<a href='oguzkorkut.com'>oguzkorkut.com</a>" + " $1";
			footnoot = tseActivationFootnoot;
			header = tseActivationSubject;
			htmlPath = "MailActivationTemplate.vm";
			referansDate = "";
		} else if (mailType == 2) {// Password
			greetings = tsePasswordGreetings;
			body = tsePasswordBody;
			footnoot = tsePasswordFootnoot;
			header = tsePasswordSubject;
			htmlPath = "MailPasswordResetTemplate.vm";

			body = body.replace("$referansdate", referansDate);
			body = body.replace("$fullname", nickName);
			body = body.replace("$passwordlink", "<a href='oguzkorkut.com'>oguzkorkut.com</a>");
		} else if (mailType == 3) {// Firma Yetki iptali
			greetings = tseCompanyRepresentativeGreetings;
			body = tseCompanyRepresentativeBody;
			footnoot = tseCompanyRepresentativeFootnoot;
			header = tseCompanyRepresentativeSubject;
			htmlPath = "MailCancelRepresentativeTemplate.vm";

			body = body.replace("$userTC", TC);
			body = body.replace("$fullName", fullName);
			body = body.replace("$firma", firma);
		}

		body = body.replace("$1", "<br>");
		footnoot = footnoot.replace("$1", "<br>");
		footnoot = footnoot.replace("$tselink", "<a href=" + tseLink + ">" + tseLink + "</a>");

		String text = getHtmlTemplate(header, greetings, emailToName, referansDate, body, footnoot, htmlPath);

		logger.info("getHtmlContent bitti.");
		return text.toString();
	}

	private String getHtmlTemplate(String header, String greetings, String mailTo, String referansDate, String body, String footnoot, String htlPath) {
		logger.info("getHtmlTemplate basladi. header:" + header + " greetings:" + greetings + " mailTo:" + mailTo + " referansDate:" + referansDate + " body:"
				+ body + " footnoot:" + footnoot + " htlPath:" + htlPath);
		Map model = new HashMap();
		model.put("header", header);
		model.put("greetings", greetings);
		model.put("mailTo", mailTo);
		model.put("referansDate", referansDate);
		model.put("body", body);
		model.put("footnoot", footnoot);
		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "com/j32bit/tse/mail/template/" + htlPath, "UTF-8", model);

		logger.info("getHtmlTemplate bitti.");
		return text;
	}

	@Override
	public boolean cancelRepresentativeMail(String emailTo, String TC, String userFullName, String company, String langCode) throws Exception {
		logger.info("sendMail basladi. TC:" + TC + " userFullName:" + userFullName + " company:" + company + " langCode:" + langCode);

		try {

			fillMailFieldByProperityFile(langCode);

			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart messageMultipart = new MimeMultipart();

			String contentType = ContentTypeEnum.HTML_CONTENT_TYPE.getContentType();

			if (StringUtils.isBlank(contentType)) {
				contentType = ContentTypeEnum.TEXT_CONTENT_TYPE.getContentType();
			}
			contentType += "; charset=UTF-8";
			String body = getHtmlContent(3, "", "", "", "", TC, userFullName, company);

			messageBodyPart.setText(body, encoding);
			messageBodyPart.setHeader("Content-type", contentType);
			messageMultipart.addBodyPart(messageBodyPart);
			mimeMessage.setContent(messageMultipart);

			mimeMessage.setSubject(tseCompanyRepresentativeSubject, "UTF-8");

			mimeMessage.setFrom(new InternetAddress(from));

			if (StringUtils.isBlank(emailTo)) {
				throw new Exception("Email TO information has not been set!");
			}

			mimeMessage.setRecipients(Message.RecipientType.TO, emailTo);

			mailSender.send(mimeMessage);

			logger.info("html mail sent to " + emailTo);
		} catch (Exception e) {
			logger.error(e, e);
			logger.fatal("Mail Gonderimi Sirasinda Bir Hata olustu Hata:" + e);
			throw e;
		}
		logger.info("sendMail bitti.");
		return true;
	}

	private void fillMailFieldByProperityFile(String langCode) throws Exception {

		logger.info("fillMailFieldByProperityFile basladi. languageCode:" + langCode);
		Properties propMailContent = new Properties();

		try {
			logger.info(langCode + "_Language_Mail.properties dosyasında veriler yuklenecek");
			propMailContent.load(getClass().getResourceAsStream("/Configuration/" + langCode + "_Language_Mail.properties"));
		} catch (Exception e) {
			logger.info(langCode + "_Language_Mail.properties dosyası bulunamadıgından default TR dosyası yuklenecek");
			try {
				propMailContent.load(getClass().getResourceAsStream("/Configuration/TR_Language_Mail.properties"));
			} catch (IOException e1) {
				logger.error("Mail dil dosyası yuklenemedi. Hata:" + e1);
				logger.fatal("Mail dil dosyası yuklenemedi. Hata:" + e1);
				throw e1;
			}
			// TODO: handle exception
		}

		// Activation
		tseActivationSubject = propMailContent.getProperty("tse.activation.subject", null).trim();
		tseActivationGreetings = propMailContent.getProperty("tse.activation.greetings", null).trim();
		tseActivationTo = propMailContent.getProperty("tse.activation.to", null).trim();
		tseActivationBody = propMailContent.getProperty("tse.activation.body", null).trim();
		tseActivationLink = propMailContent.getProperty("tse.activation.link", null).trim();
		tseActivationFootnoot = propMailContent.getProperty("tse.activation.footnoot", null).trim();
		// Password
		tsePasswordSubject = propMailContent.getProperty("tse.password.subject", null).trim();
		tsePasswordGreetings = propMailContent.getProperty("tse.password.Greetings", null).trim();
		tsePasswordBody = propMailContent.getProperty("tse.password.body", null).trim();
		tsePasswordLink = propMailContent.getProperty("tse.password.link", null).trim();
		tsePasswordFootnoot = propMailContent.getProperty("tse.password.footnoot", null).trim();

		tseCompanyRepresentativeSubject = propMailContent.getProperty("tse.company.subject", null).trim();
		tseCompanyRepresentativeGreetings = propMailContent.getProperty("tse.company.Greetings", null).trim();
		tseCompanyRepresentativeBody = propMailContent.getProperty("tse.company.body", null).trim();
		tseCompanyRepresentativeLink = propMailContent.getProperty("tse.company.link", null).trim();
		tseCompanyRepresentativeFootnoot = propMailContent.getProperty("tse.company.footnoot", null).trim();

		logger.info("fillMailFieldByProperityFile bitti.");
		tseLink = propMailContent.getProperty("tse.link", null).trim();
	}
	
	private FileInputStream getInputStreamByFile(String path)
			throws FileNotFoundException {
		File file1 = new File(path);
		FileInputStream fis1 = null;
		fis1 = new FileInputStream(file1);
		return fis1;
	}

	public JavaMailSenderImpl getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
