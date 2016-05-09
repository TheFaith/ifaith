package com.ifaith.fellowship.dataaccess.people;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ifaith.fellowship.dataaccess.common.DataSourceManager;
import com.ifaith.fellowship.entity.auth.AuthenticateToken;
import com.ifaith.fellowship.entity.auth.AuthenticateTokenQC;

@Repository
public class AuthenticateTokenRepoImp implements AuthenticateTokenRepository {

	@Override
	public int add(AuthenticateToken entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			AuthTokenMapper mapper = session.getMapper(AuthTokenMapper.class);
			mapper.insertAuthToken(entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int save(AuthenticateToken entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			AuthTokenMapper mapper = session.getMapper(AuthTokenMapper.class);
			mapper.updateAuthToken(entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int remove(int sysNo) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			AuthTokenMapper mapper = session.getMapper(AuthTokenMapper.class);
			count = mapper.deleteAuthToken(sysNo);
			session.commit();
		}
		return count;
	}

	@Override
	public AuthenticateToken find(int sysNo) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		AuthenticateToken token = null;
		try (SqlSession session = sessionFactory.openSession()) {
			AuthTokenMapper mapper = session.getMapper(AuthTokenMapper.class);
			token = mapper.getAuthToken(sysNo);
			session.commit();
		}
		return token;
	}

	@Override
	public List<AuthenticateToken> findsBy(AuthenticateTokenQC query) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		List<AuthenticateToken> tokens = null;
		try (SqlSession session = sessionFactory.openSession()) {
			AuthTokenMapper mapper = session.getMapper(AuthTokenMapper.class);
			tokens = mapper.queryAuthTokens(query);
		}
		return tokens;
	}

	@Override
	public AuthenticateToken findBy(int consumerSysNo, int userSysNo) throws Exception {
		AuthenticateToken token = null;

		AuthenticateTokenQC query = new AuthenticateTokenQC();
		query.setConsumerSysNo(consumerSysNo);
		query.setUserSysNo(userSysNo);
		List<AuthenticateToken> tokens = this.findsBy(query);
		if (tokens != null && tokens.size() > 0) {
			token = tokens.get(0);
		}
		return token;
	}

	@Override
	public AuthenticateToken findBy(String accessToken) throws Exception {
		AuthenticateToken token = null;

		AuthenticateTokenQC query = new AuthenticateTokenQC();
		query.setAccessToken(accessToken);
		List<AuthenticateToken> tokens = this.findsBy(query);
		if (tokens != null && tokens.size() > 0) {
			token = tokens.get(0);
		}
		return token;
	}

}
