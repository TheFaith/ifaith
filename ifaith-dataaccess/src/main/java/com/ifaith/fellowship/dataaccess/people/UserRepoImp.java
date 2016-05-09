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

	@Override
	public int add(UserBasicInfo entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			count = mapper.insertUser(entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int save(UserBasicInfo entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			count = mapper.updateUser(entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int remove(int sysNo) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			count = mapper.deleteUser(sysNo);
			session.commit();
		}
		return count;
	}

	@Override
	public UserBasicInfo find(int sysNo) throws IOException {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		UserBasicInfo user = null;
		try (SqlSession session = sessionFactory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			user = mapper.getUser(sysNo);
		}
		return user;
	}

	@Override
	public List<UserBasicInfo> findsBy(BasiceQueryCondition query) {
		// TODO Auto-generated method stub
		return null;
	}

}
