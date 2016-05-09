package com.ifaith.fellowship.dataaccess.people;

import java.util.List;

import com.ifaith.fellowship.entity.auth.AuthenticateToken;
import com.ifaith.fellowship.entity.auth.AuthenticateTokenQC;

public interface AuthTokenMapper {
	public List<AuthenticateToken> queryAuthTokens(AuthenticateTokenQC query);
	public AuthenticateToken getAuthToken(int sysNo);
	public int insertAuthToken(AuthenticateToken token);
	public int updateAuthToken(AuthenticateToken token);
	public int deleteAuthToken(int sysNo);
	
}
