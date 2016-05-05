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

	protected final String STATEMENT_CONSUMER_GET = "com.ifaith.fellowship.consumerMapper.getConsumer";
	protected final String STATEMENT_CONSUMER_QUERY = "com.ifaith.fellowship.consumerMapper.queryConsumer";
	protected final String STATEMENT_CONSUMER_INSERT = "com.ifaith.fellowship.consumerMapper.insertConsumer";
	protected final String STATEMENT_CONSUMER_UPDATE = "com.ifaith.fellowship.consumerMapper.updateConsumer";
	protected final String STATEMENT_CONSUMER_DELETE = "com.ifaith.fellowship.consumerMapper.deleteConsumer";

	@Override
	public int add(Consumer entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.insert(STATEMENT_CONSUMER_INSERT, entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int save(Consumer entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();

		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.update(STATEMENT_CONSUMER_UPDATE, entity);
			session.commit();
		}
		return count;
	}

	@Override
	public int remove(Consumer entity) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		int count = 0;
		try (SqlSession session = sessionFactory.openSession()) {
			session.delete(STATEMENT_CONSUMER_DELETE, entity);
			session.commit();
		}
		return count;
	}

	@Override
	public Consumer find(int sysNo) throws IOException {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		Consumer consumer = null;
		try (SqlSession session = sessionFactory.openSession()) {
			consumer = session.selectOne(STATEMENT_CONSUMER_GET, sysNo);
			session.commit();
		}
		return consumer;
	}

	@Override
	public List<Consumer> findsBy(ConsumerQC query) throws Exception {
		SqlSessionFactory sessionFactory = DataSourceManager.createSessionFactory();
		List<Consumer> consumers = null;
		try (SqlSession session = sessionFactory.openSession()) {
			consumers = session.selectList(STATEMENT_CONSUMER_QUERY, query);
			session.commit();
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
