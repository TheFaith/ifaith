package com.ifaith.fellowship.entity.auth;

import com.ifaith.fellowship.entity.common.BasicEntity;

public class Consumer extends BasicEntity {

	public int consumerAppID = 0;
	public String consumerName = null;
	public String consumerKey = null;
	public String consumerSecret = null;
	public boolean isEnabled = false;

	public int getConsumerAppID() {
		return consumerAppID;
	}

	public void setConsumerAppID(int consumerAppID) {
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

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public ConsumerApp getConsumerApp()
	{
		return ConsumerApp.Covert(this.consumerAppID);
	}
	
}
