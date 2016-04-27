package com.ifaith.fellowship.dataaccess.people;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ifaith.fellowship.dataaccess.common.DataSourceManager;
import com.ifaith.fellowship.dataaccess.common.QueryCondition;
import com.ifaith.fellowship.dataaccess.common.Repository;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

public class UserRepo implements Repository<UserBasicInfo, Object> {
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
	public int delete(UserBasicInfo entity) throws Exception{
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
	public UserBasicInfo find(int sysNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBasicInfo> query(QueryCondition<Object> query) {
		// TODO Auto-generated method stub
		return null;
	}

}
