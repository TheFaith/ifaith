package com.ifaith.fellowship.dataaccess.people;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ifaith.fellowship.dataaccess.common.DataSourceManager;
import com.ifaith.fellowship.entity.auth.Consumer;
import com.ifaith.fellowship.entity.auth.ConsumerQC;

@Repository
public class ConsumerRepoImp implements ConsumerRepository {

	@Override
	public int add(Consumer entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);
			mapper.insertConsumer(entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int save(Consumer entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);
			mapper.updateConsumer(entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int remove(int sysNo) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);
			mapper.deleteConsumer(sysNo);
			session.commit();
		}
		return count;
	}

	@Override
	public Consumer find(int sysNo) throws IOException {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		Consumer consumer = null;
		try (SqlSession session = sessionFactory.openSession()) {
			ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);
			consumer = mapper.getConsumer(sysNo);
		}
		return consumer;
	}

	@Override
	public List<Consumer> findsBy(ConsumerQC query) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		List<Consumer> consumers = null;
		try (SqlSession session = sessionFactory.openSession()) {
			ConsumerMapper mapper = session.getMapper(ConsumerMapper.class);
			consumers = mapper.queryConsumers(query);
		}
		return consumers;
	}

	@Override
	public Consumer findBy(String key, String secret) throws Exception {
		Consumer consumer = null;
		ConsumerQC query = new ConsumerQC();
		query.setConsumerKey(key);
		query.setConsumerSecret(secret);
		List<Consumer> consumers = this.findsBy(query);
		if (consumers != null && consumers.size() > 0) {
			consumer = consumers.get(0);
		}
		return consumer;
	}

}
