package com.ifaith.fellowship.entity.auth;

public enum ConsumerApp {
	Unknow(0), Daycare(1000), AdminUI(1001), CustomerUI(1002);

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

	public static ConsumerApp Covert(int value) {
		ConsumerApp app = null;
		switch (value) {
		case 1000:
			app = ConsumerApp.Daycare;
			break;
		case 1001:
			app = ConsumerApp.AdminUI;
			break;
		case 1002:
			app = ConsumerApp.CustomerUI;
			break;
		default:
			app = ConsumerApp.Unknow;
			break;
		}
		return app;
	}
}
