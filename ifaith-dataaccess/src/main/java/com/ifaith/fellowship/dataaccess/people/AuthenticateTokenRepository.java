package com.ifaith.fellowship.dataaccess.people;

import com.ifaith.fellowship.dataaccess.common.Repository;
import com.ifaith.fellowship.entity.auth.AuthenticateToken;
import com.ifaith.fellowship.entity.auth.AuthenticateTokenQC;

public interface AuthenticateTokenRepository extends Repository<AuthenticateToken, AuthenticateTokenQC> {
	public AuthenticateToken findBy(int consumerSysNo, int userSysNo) throws Exception;
}
