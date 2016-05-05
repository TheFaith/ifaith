package com.ifaith.fellowship.entity.auth;

import com.ifaith.fellowship.entity.common.BasiceQueryCondition;

public class ConsumerQC extends BasiceQueryCondition {
	public Integer consumerAppID;
	public String consumerName;
	public String consumerKey;
	public String consumerSecret;
	public Boolean isEnabled;

	public Integer getConsumerAppID() {
		return consumerAppID;
	}

	public void setConsumerAppID(Integer consumerAppID) {
		this.consumerAppID = consumerAppID;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}
