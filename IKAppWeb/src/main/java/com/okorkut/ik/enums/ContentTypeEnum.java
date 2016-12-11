package com.okorkut.ik.enums;

public enum ContentTypeEnum {
	HTML_CONTENT_TYPE("text/html"),
	TEXT_CONTENT_TYPE("text/plain");
	
	private String contentType;
	
	private ContentTypeEnum(String contentType){
		this.contentType = contentType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
