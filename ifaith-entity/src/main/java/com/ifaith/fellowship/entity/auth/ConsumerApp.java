package com.ifaith.fellowship.entity.auth;

public enum ConsumerApp {
	Unknow(0), AdminUI(1001), CustomerUI(1002), Daycare(1003);

	private ConsumerApp(int value) {
		this.setValue(value);
	}

	private int value;

	public void setValue(int value) {
		this.value = value;
	}

	public int setValue() {
		return this.value;
	}
}

