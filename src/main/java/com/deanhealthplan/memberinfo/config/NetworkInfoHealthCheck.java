package com.deanhealthplan.memberinfo.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

import com.deanhealthplan.memberinfo.service.impl.NetworkInfoImpl;

@Component
public class NetworkInfoHealthCheck extends AbstractHealthIndicator {

	@Autowired
	private NetworkInfoImpl networkInfo;
	
	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		try {
			// call Network Info
			networkInfo.pmbr1dl4ListMemberNetworksT("1234567", "01", "19821206", "19921206");
			
			builder.up();
		} catch (Exception e) {
			builder.down();
		}
		
	}

	
	
}
