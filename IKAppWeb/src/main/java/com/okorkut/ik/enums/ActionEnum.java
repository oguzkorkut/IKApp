package com.okorkut.ik.enums;

public enum ActionEnum {

	APPLICATION("APPLICATION", "Başvuru Aşamasında"), APPROVE_IK("APPROVE_IK",
			"İnsan KAynakları Onayladı"), APPROVE_MANAGER("APPROVE_MANAGER",
					"Yönetici Onayladı"), APPROVE("APPROVE", "İş Başvurusu Onaylandı"), REJECT("REJECT", "Başvuru Reddedildi");

	private String code;
	private String value;

	private ActionEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static String getValueByCode(String code) {

		for (ActionEnum e : ActionEnum.values()) {
			if (e.getCode().equalsIgnoreCase(code)) {
				return e.getValue();
			}
		}
		return "";

	}

}
