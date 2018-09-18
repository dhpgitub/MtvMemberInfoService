package com.deanhealthplan.memberinfo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@ConfigurationProperties("mtv")
public class MTVProperties {

	private String MTVUser;
	private String MTVPassword;
	private String MTVURL;

	public String getMTVUser() {
		return MTVUser;
	}

	public void setMTVUser(String mTVUser) {
		MTVUser = mTVUser;
	}

	public String getMTVPassword() {
		return MTVPassword;
	}

	public void setMTVPassword(String mTVPassword) {
		MTVPassword = mTVPassword;
	}

	public String getMTVURL() {
		return MTVURL;
	}

	public void setMTVURL(String mTVURL) {
		MTVURL = mTVURL;
	}
	
	
}
