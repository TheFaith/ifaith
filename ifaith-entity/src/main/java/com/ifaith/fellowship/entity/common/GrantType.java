package com.ifaith.fellowship.entity.common;

public enum GrantType {
	Unknow("unknow"), AuthorizationCode("authorization_code"), Implicit("implicit"), ResOwnerPwdCredentials(
			"password"), ClientCredentials("client_credentials"), RefreshToken("refresh_token");

	public static GrantType Convert(String value) {
		GrantType type = null;
		switch (value) {
		case "authorization_code":
			type = GrantType.AuthorizationCode;
			break;
		case "implicit":
			type = GrantType.Implicit;
			break;
		case "password":
			type = GrantType.ResOwnerPwdCredentials;
			break;
		case "client_credentials":
			type = GrantType.ClientCredentials;
			break;
		case "refresh_token":
			type = GrantType.RefreshToken;
			break;
		default:
			type = GrantType.Unknow;
			break;
		}
		return type;
	}

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
}
