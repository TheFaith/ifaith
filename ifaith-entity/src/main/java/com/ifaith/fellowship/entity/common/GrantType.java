package com.ifaith.fellowship.entity.common;

public enum GrantType {
	Unknow("unknow"), 
	AuthorizationCode("authorization_code"), 
	Implicit("implicit"), 
	ResOwnerPwdCredentials("password"), 
	ClientCredentials("client_credentials"), 
	RefreshToken("refresh_token");

	private GrantType(String value) {
		this.setValue(value);
	}

	private String value;

	public void setValue(String value) {
		this.value = value;
	}

	public String setValue() {
		return this.value;
	}
	
	public static GrantType Convert(String value) {
		GrantType type = GrantType.Unknow;
		for (GrantType curType : GrantType.values()) {
			if (value.equals(curType.value)) {
				type = curType;
			}
		}
		return type;
	}
}
