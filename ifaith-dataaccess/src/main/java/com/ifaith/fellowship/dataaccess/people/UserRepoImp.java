package com.ifaith.fellowship.dataaccess.people;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ifaith.fellowship.dataaccess.common.DataSourceManager;
import com.ifaith.fellowship.entity.common.BasiceQueryCondition;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

@Repository
public class UserRepoImp implements UserRepository {
	protected final String STATEMENT_USER_INSERT = "com.ifaith.fellowship.userMapper.insertUser";
	protected final String STATEMENT_USER_UPDATE = "com.ifaith.fellowship.userMapper.updateUser";
	protected final String STATEMENT_USER_DELETE = "com.ifaith.fellowship.userMapper.deleteUser";
	protected final String STATEMENT_USER_GET = "com.ifaith.fellowship.userMapper.getUser";

	@Override
	public int add(UserBasicInfo entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.insert(STATEMENT_USER_INSERT, entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int save(UserBasicInfo entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.update(STATEMENT_USER_UPDATE, entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int remove(UserBasicInfo entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.delete(STATEMENT_USER_DELETE, entity);
			session.commit();
		}
		return count;
	}

	@Override
	public UserBasicInfo find(int sysNo) throws IOException {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		UserBasicInfo user = null;
		try (SqlSession session = sessionFactory.openSession()) {
			user = session.selectOne(STATEMENT_USER_GET, sysNo);
			session.commit();
		}
		return user;
	}

	@Override
	public List<UserBasicInfo> findsBy(BasiceQueryCondition query) {
		// TODO Auto-generated method stub
		return null;
	}

}
