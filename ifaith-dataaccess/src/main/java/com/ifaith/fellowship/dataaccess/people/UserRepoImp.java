package com.ifaith.fellowship.dataaccess.people;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ifaith.fellowship.dataaccess.common.DataSourceManager;
import com.ifaith.fellowship.dataaccess.common.QueryCondition;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

@Repository
public class UserRepoImp implements UserRepository {
	// TODO Begin this will move to common.
	// TODO End this will move to common.

	@Override
	public int insert(UserBasicInfo entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		String statement = "com.ifaith.fellowship.userMapper.insertUser";

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.insert(statement, entity);
			session.commit();
		}

		return count;
	}

	@Override
	public int update(UserBasicInfo entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		String statement = "com.ifaith.fellowship.userMapper.updateUser";

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.update(statement, entity);
			session.commit();
		}

		return count;
	}

	@Override
	public int delete(UserBasicInfo entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		String statement = "com.ifaith.fellowship.userMapper.deleteUser";

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.delete(statement, entity);
			session.commit();
		}

		return count;
	}

	@Override
	public UserBasicInfo find(int sysNo) throws IOException {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		String statement = "com.ifaith.fellowship.userMapper.getUser";
		UserBasicInfo user = null;
		try (SqlSession session = sessionFactory.openSession()) {
			user = session.selectOne(statement, sysNo);
			session.commit();
		}

		return user;
	}

	@Override
	public List<UserBasicInfo> query(QueryCondition<Object> query) {
		// TODO Auto-generated method stub
		return null;
	}

}
