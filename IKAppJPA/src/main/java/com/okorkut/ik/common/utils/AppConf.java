package com.okorkut.ik.common.utils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "appConf")
public class AppConf {

	private String appName = "IKApp";
	private String version = "v1.0";
	private String createDate = "06.12.2016";
	private String updateDate  = "06.12.2016";
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("\n").append("App={").append("\n")
			.append("appName:" + appName).append("\n")
			.append("version:" + version).append("\n")
			.append("createDate:" + createDate).append("\n")
			.append("updateDate:" + updateDate).append("\n")
			.append("}");
		return str.toString();
	}
	
	

}
