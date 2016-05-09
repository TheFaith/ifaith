package com.ifaith.fellowship.dataaccess.people;

import java.util.List;

import com.ifaith.fellowship.entity.auth.Consumer;
import com.ifaith.fellowship.entity.auth.ConsumerQC;

public interface ConsumerMapper {
	public List<Consumer> queryConsumer(ConsumerQC query);

	public Consumer getConsumer(int sysNo);

	public int insertConsumer(Consumer consumer);

	public int updateConsumer(Consumer consumer);

	public int deleteConsumer(int sysNo);
}
