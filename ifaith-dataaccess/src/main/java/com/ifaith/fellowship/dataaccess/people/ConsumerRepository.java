package com.ifaith.fellowship.dataaccess.people;

import com.ifaith.fellowship.dataaccess.common.Repository;
import com.ifaith.fellowship.entity.auth.Consumer;
import com.ifaith.fellowship.entity.auth.ConsumerQC;

public interface ConsumerRepository extends Repository<Consumer,ConsumerQC> {

	public Consumer findBy(String key,String secret) throws Exception;
}
