package com.okorkut.ik.enums;

public enum ActionEnum {

	APPLICATION("APPLICATION"), APPROVE_IK("APPROVE_IK"), APPROVE_MANAGER("APPROVE_MANAGER"), REJECT("REJECT");

	private String value;

	private ActionEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
