package com.okorkut.ik.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author oguz
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "genericValue")
public class GenericValueDto {

	private Integer id;
	private String code;
	private String value;
	private boolean checked;

	public GenericValueDto() {
	}

	/**
	 * 
	 * @param id
	 * @param code
	 * @param value
	 * @param checked
	 */
	public GenericValueDto(Integer id, String code, String value, boolean checked) {
		this.id = id;
		this.code = code;
		this.value = value;
		this.checked = checked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the checked
	 */
	public boolean getChecked() {
		return checked;
	}

	/**
	 * @param checked
	 *            the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
