package com.ifaith.fellowship.dataaccess.people;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ifaith.fellowship.dataaccess.common.DataSourceManager;
import com.ifaith.fellowship.entity.auth.AuthenticateToken;
import com.ifaith.fellowship.entity.auth.AuthenticateTokenQC;

@Repository
public class AuthenticateTokenRepoImp implements AuthenticateTokenRepository{

	protected final String STATEMENT_AUTHTOKEN_GET = "com.ifaith.fellowship.authTokenMapper.getAuthToken";
	protected final String STATEMENT_AUTHTOKEN_QUERY = "com.ifaith.fellowship.authTokenMapper.queryAuthToken";
	protected final String STATEMENT_AUTHTOKEN_INSERT = "com.ifaith.fellowship.authTokenMapper.insertAuthToken";
	protected final String STATEMENT_AUTHTOKEN_UPDATE = "com.ifaith.fellowship.authTokenMapper.updateAuthToken";
	protected final String STATEMENT_AUTHTOKEN_DELETE = "com.ifaith.fellowship.authTokenMapper.deleteAuthToken";
	
	@Override
	public int add(AuthenticateToken entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.insert(STATEMENT_AUTHTOKEN_INSERT, entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int save(AuthenticateToken entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.update(STATEMENT_AUTHTOKEN_UPDATE, entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int remove(AuthenticateToken entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.delete(STATEMENT_AUTHTOKEN_DELETE, entity);
			session.commit();
		}
		return count;
	}

	@Override
	public AuthenticateToken find(int sysNo) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		AuthenticateToken token = null;
		try (SqlSession session = sessionFactory.openSession()) {
			token = session.selectOne(STATEMENT_AUTHTOKEN_GET, sysNo);
			session.commit();
		}
		return token;
	}

	@Override
	public List<AuthenticateToken> findsBy(AuthenticateTokenQC query) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		List<AuthenticateToken> tokens = null;
		try (SqlSession session = sessionFactory.openSession()) {
			tokens = session.selectList(STATEMENT_AUTHTOKEN_QUERY, query);
			session.commit();
		}
		return tokens;
	}

	@Override
	public AuthenticateToken findBy(int consumerSysNo, int userSysNo) throws Exception {
		AuthenticateTokenQC query = new AuthenticateTokenQC();
		query.setConsumerSysNo(consumerSysNo);
		query.setUserSysNo(userSysNo);
		
		AuthenticateToken token = null;
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		try (SqlSession session = sessionFactory.openSession()) {
			token = session.selectOne(STATEMENT_AUTHTOKEN_QUERY, query);
			session.commit();
		}
		return token;
	}

}
